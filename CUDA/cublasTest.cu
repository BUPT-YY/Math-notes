//Usage: set in vscode-code_runner:
// "code-runner.executorMapByFileExtension": {
//        ".cu": "cd $dir && nvcc -lcublas $fileName -o $fileNameWithoutExt && $dir$fileNameWithoutExt",
//    },
#include <iostream>
#include <random>
#include <cmath>
//#include <chrono>
#include <vector>
#include <algorithm>
#include <string>
#include "/usr/local/cuda-10.2/include/cuda_runtime.h"
#include "/usr/local/cuda-10.2/include/device_launch_parameters.h"
#include "/usr/local/cuda-10.2/include/cublas_v2.h"
std::random_device rd;
std::default_random_engine e{rd()};
std::uniform_real_distribution<float> uniform(0,1);
using YYmatrix = std::vector<float>;


void generate(int size, float* vec) {
  //static std::vector<float> vec(size, 0);
  for(int i = 0; i < size; ++i) {
    vec[i] = uniform(e);
  }
  //return vec;
}

void matrixMmultCPU(  //both column-major
  float* A,  // N by K
  float* B,  // K by M
  float* C,  // N by M
    int N, int K, int M) { 
  for(int i = 0; i < N; ++i) {
    for(int j = 0; j < M; ++j) {
      float res = 0.0f;
      for(int k = 0; k < K; ++k) {
        res += A[i+ k*N] * B[k+j*K];
      }
      C[i+j*N] = res;
    }
  }
}


//A:N*K, B:K*M
const int N = 1024;
const int K = 2048;
const int M = 1024;

int main() {
    float* h_a, * h_b, * h_c;


    cudaMallocHost((void**)&h_a, sizeof(float)*N*K);
    cudaMallocHost((void**)&h_b, sizeof(float)*K*M);
    cudaMallocHost((void**)&h_c, sizeof(float)*N*M);

    generate(N*K, h_a);
    generate(K*M, h_b);

    float* d_a, *d_b, *d_c;
    cudaMalloc(&d_a, sizeof(float)*N*K);
    cudaMalloc(&d_b, sizeof(float)*K*M);
    cudaMalloc(&d_c, sizeof(float)*N*M);

    cublasHandle_t handle;
    cublasCreate_v2(&handle);
    cudaMemcpy(d_a,h_a,sizeof(float)*N*K,cudaMemcpyHostToDevice); //数据从内存拷贝到显存
    cudaMemcpy(d_b,h_b,sizeof(float)*K*M,cudaMemcpyHostToDevice);

    float alpha = 2.0f, beta = 0.0f;

  float usedTime;
  cudaEvent_t start_GPU, stop_GPU; cudaEventCreate(&start_GPU); cudaEventCreate(&stop_GPU);
  cudaEventRecord(start_GPU, 0);
    cublasSgemm_v2(
        handle,
        CUBLAS_OP_N,
        CUBLAS_OP_N,
        N, M, K,
        &alpha,
        d_a, M,
        d_b, K,
        &beta,
        d_c, M
    );
  cudaEventRecord(stop_GPU, 0);
  cudaEventSynchronize(start_GPU);    //等待事件完成。
  cudaEventSynchronize(stop_GPU);    //等待事件完成。记录之前的任务
  cudaEventElapsedTime(&usedTime, start_GPU, stop_GPU);    //计算时间差
  cudaEventDestroy(start_GPU);cudaEventDestroy(stop_GPU);    //消除Event
  

    cudaMemcpy(h_c, d_c, sizeof(float)*N*M, cudaMemcpyDeviceToHost);

    cudaFree(d_a);
    cudaFree(d_b);
    cudaFree(d_c);

    std::cout << "Used time: " << usedTime*1000.0f << "μs." << std::endl;
    std::cout << "GPU average Throughput: " << 2.0*N*M*K/usedTime/1.0e6 << "GFLOPS" << std::endl; 

  float* h_d = (float*)malloc(sizeof(float)*N*M); 

    matrixMmultCPU(h_a,h_b,h_d,N,K,M);
      float l2error = 0;
      for(int i = 0; i < N*M; ++i) {
          float temp = (h_c[i]-2.0f*h_d[i]);
          l2error += temp*temp;
      }
      l2error = sqrt(l2error);
      std::string result = (l2error < 0.05) ? ", test passed." : ", test failed."; 
      std::cout << "GPU error = " << l2error << result << std::endl;

  free(h_d);
  cudaFreeHost((void*)h_a);
  cudaFreeHost((void*)h_b);
  cudaFreeHost((void*)h_c);

    return 0;
}

