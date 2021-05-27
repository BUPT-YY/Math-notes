#include <iostream>
#include <random>
#include <cmath>
//#include <chrono>
#include <vector>
#include <algorithm>
#include "/usr/local/cuda-10.2/include/cuda_runtime.h"
#include "/usr/local/cuda-10.2/include/device_launch_parameters.h"

std::random_device rd;
std::default_random_engine e{rd()};
std::uniform_real_distribution<float> uniform(0,1);
using YYmatrix = std::vector<float>;


std::vector<float> generate(int size) {
  static std::vector<float> vec(size, 0);
  for(int i = 0; i < size; ++i) {
    vec[i] = uniform(e);
  }
  return vec;
}

#define BLOCK_SIZE 32
// Kernel function to add the elements of two arrays
__global__ void mmult(float* A, float* B, float* C, int K, int M) {
  int blockCol = blockIdx.x, blockRow = blockIdx.y;
  float runningSum = 0.0f;
  int col = threadIdx.x,row = threadIdx.y;
  int BK = K/BLOCK_SIZE;
  for(int bk = 0; bk < BK; ++bk) {
    float* asub = A + K * BLOCK_SIZE * blockRow + BLOCK_SIZE * bk;
    float* bsub = B + M * BLOCK_SIZE * bk + BLOCK_SIZE * blockCol;
    __shared__ float as[BLOCK_SIZE][BLOCK_SIZE];
    __shared__ float bs[BLOCK_SIZE][BLOCK_SIZE];
    as[row][col] = asub[row*K + col];
    bs[row][col] = bsub[row*M + col];
    __syncthreads();
    for(int e = 0; e < BLOCK_SIZE; ++e) {
      runningSum += as[row][e] * bs[e][col];
    }
    __syncthreads();
  }
  float* csub = C + M * BLOCK_SIZE * blockRow + BLOCK_SIZE * blockCol;
  csub[row*M + col] = runningSum;
}

void matrixMmultCPU(  //both row-major
  const YYmatrix& A,  // N by K
  const YYmatrix& B,  // K by M
        YYmatrix& C,  // N by M
        int K) {
   int N = A.size()/K, M = B.size()/K;  
  for(int i = 0; i < N; ++i) {
    for(int j = 0; j < M; ++j) {
      float res = 0.0f;
      for(int k = 0; k < K; ++k) {
        res += A[i*K + k] * B[k*M+j];
      }
      C[i*M+j] = res;
    }
  }
}

double matrixMmultGPU(  //both row-major
    YYmatrix& A,  // N by K
    YYmatrix& B,  // K by M
    YYmatrix& C,  // N by M
        int K) {
  int N = A.size()/K, M = B.size()/K;  
  float* gpu_a = nullptr, *gpu_b = nullptr, *gpu_c = nullptr; 
  cudaMalloc((void**)&gpu_a, N*K*sizeof(float));
  cudaMalloc((void**)&gpu_b, K*M*sizeof(float));
  cudaMalloc((void**)&gpu_c, N*M*sizeof(float));


  //auto timeStart = std::chrono::system_clock::now();
  cudaMemcpy(gpu_a,A.data() , N*K*sizeof(float), cudaMemcpyHostToDevice);
  cudaMemcpy(gpu_b,B.data() , K*M*sizeof(float), cudaMemcpyHostToDevice);  

  float usedTime;
  cudaEvent_t start_GPU, stop_GPU; cudaEventCreate(&start_GPU); cudaEventCreate(&stop_GPU);
  cudaEventRecord(start_GPU, 0);

  dim3 threadDim(BLOCK_SIZE, BLOCK_SIZE);
  dim3 blockDim(M/BLOCK_SIZE, N/BLOCK_SIZE);
  mmult<<<blockDim,threadDim>>>(gpu_a, gpu_b, gpu_c, K,M);
  cudaEventRecord(stop_GPU, 0);
  cudaEventSynchronize(start_GPU);    //等待事件完成。
  cudaEventSynchronize(stop_GPU);    //等待事件完成。记录之前的任务
  cudaEventElapsedTime(&usedTime, start_GPU, stop_GPU);    //计算时间差
  cudaEventDestroy(start_GPU);cudaEventDestroy(stop_GPU);    //消除Event
  


  cudaMemcpy(C.data(), gpu_c, N*M*sizeof(float), cudaMemcpyDeviceToHost);
  //auto timeUsed = std::chrono::system_clock::now() - timeStart;

  cudaFree(gpu_a);
  cudaFree(gpu_b);
  cudaFree(gpu_c);
  return usedTime*1000.0f;
  //return timeUsed.count()/1000.0;
}




int main(void)
{
  
  //This Kernel computes C = A * B, where
  // A is a N * K matrix,
  // B is a K * M matrix
  constexpr int N = 16*BLOCK_SIZE;
  constexpr int K = 32*BLOCK_SIZE;
  constexpr int M = 16*BLOCK_SIZE;
  
  int TestTime = 1; std::vector<float> statistics;
  for(int t = 0; t < TestTime; ++t) {
    YYmatrix A = generate(N*K), B = generate(K*M), C(N*M,0), D(N*M, 0);
    statistics.push_back(matrixMmultGPU(A,B,C,K));

    if(t==0) {  //exam the result in the first time
      matrixMmultCPU(A,B,D,K);
      float l2error = 0;
      for(int i = 0; i < N; ++i) {
        for(int j = 0; j < M; ++j) {
          float temp = (C[i*M+j]-D[i*M+j]);
          l2error += temp*temp;
        } 
      }
      l2error = sqrt(l2error);
      std::cout << "GPU error = " << l2error << std::endl;
      
     /*for(int i = 0; i < 4; ++i) {
     for(int j = 0; j < 10; ++j)
      printf("%.2f, ", C[i*M+j]);
      std::cout << std::endl;
     }std::cout << std::endl;

     for(int i = 0; i < 4; ++i) {
     for(int j = 0; j < 10; ++j)
      printf("%.2f, ", D[i*M+j]);
      std::cout << std::endl;
     }std::cout << std::endl;*/
    }
  }
  float averageTime = std::accumulate(statistics.begin(), statistics.end(), 0.0f)/TestTime;
  std::cout << "GPU average used time: " << averageTime << "μs." << std::endl;
  std::cout << "GPU average Throughput: " << 2.0*N*M*K/averageTime/1000.0 << "GFLOPS" << std::endl;



  
  return 0;
}
