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




//A:N*K, B:K*M
const int N = 1024;
const int K = 2048;
const int M = 1024;

int main() {
    float* h_a, * h_b, * h_c;
    h_a = (float*)malloc(sizeof(float)*N*K);
    h_b = (float*)malloc(sizeof(float)*K*M);
    h_c = (float*)malloc(sizeof(float)*N*M);
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

    float alpha = 1.0f, beta = 0.0f;

  float usedTime;
  cudaEvent_t start_GPU, stop_GPU; cudaEventCreate(&start_GPU); cudaEventCreate(&stop_GPU);
  cudaEventRecord(start_GPU, 0);
    cublasSgemm_v2(
        handle,
        CUBLAS_OP_T,
        CUBLAS_OP_T,
        N, M, K,
        &alpha,
        d_a, K,
        d_b, M,
        &beta,
        d_c, N
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
    free(h_a);
    free(h_b);
    free(h_c);

    std::cout << "Used time: " << usedTime*1000.0f << "μs." << std::endl;
    std::cout << "GPU average Throughput: " << 2.0*N*M*K/usedTime/1.0e6 << "GFLOPS" << std::endl; 

    return 0;
}

