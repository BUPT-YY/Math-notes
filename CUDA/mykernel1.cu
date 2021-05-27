//tested result:
/* My device : GTX 960M
* matrix size: 1024*2048, 2048*1024
* GPU error = 0.00692065, test passed.
* GPU average used time: 3000.61μs.
* GPU average Throughput: 178.921GFLOPS
*/

#include <iostream>
#include <random>
#include <cmath>
//#include <chrono>
#include <vector>
#include <algorithm>
#include <string>
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

#define TS 32
// Kernel function to add the elements of two arrays
__global__ void mmult(float* A, float* B, float* C, int K, int M) {
  
  const int col = threadIdx.x,row = threadIdx.y;
  const int globalRow = TS*blockIdx.y + row;
  const int globalCol = TS*blockIdx.x + col;
  //int blockCol = blockIdx.x, blockRow = blockIdx.y;
  
  __shared__ float Asub[TS][TS];
  __shared__ float Bsub[TS][TS];
  
  float acc = 0.0f;

  int numTiles = K/TS;
  for(int t = 0; t < numTiles; ++t) {

    Asub[row][col] = A[K * globalRow + TS * t + col];
    Bsub[row][col] = B[M * (TS*t + row) + globalCol];
    __syncthreads();
    for(int k = 0; k < TS; ++k) {
      acc += Asub[row][k] * Bsub[k][col];
    }
    __syncthreads();
  }
  C[M * globalRow + globalCol] = acc;
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

  dim3 threadDim(TS/WPT, TS);
  dim3 blockDim(M/TS, N/TS);
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




int main()
{
  
  //This Kernel computes C = A * B, where
  // A is a N * K matrix,
  // B is a K * M matrix

  constexpr int N = 512;
  constexpr int K = 1024;
  constexpr int M = 512;
  
  int TestTime = 1; std::vector<float> statistics;
  int randTest = std::uniform_int_distribution<>(0, TestTime) (e);
  for(int t = 0; t < TestTime; ++t) {
    YYmatrix A = generate(N*K), B = generate(K*M), C(N*M,0), D(N*M, 0);
    statistics.push_back(matrixMmultGPU(A,B,C,K));

    if(t==0) {  //exam the result only once
      matrixMmultCPU(A,B,D,K);
      float l2error = 0;
      for(int i = 0; i < N; ++i) {
        for(int j = 0; j < M; ++j) {
          float temp = (C[i*M+j]-D[i*M+j]);
          l2error += temp*temp;
        } 
      }
      l2error = sqrt(l2error);
      std::string result = (l2error < 0.05) ? ", test passed." : ", test failed."; 
      std::cout << "GPU error = " << l2error << result << std::endl;
      
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
