package com.example.a24_shopping.data.network

import com.example.a24_shopping.data.response.ProductResponse
import com.example.a24_shopping.data.response.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {

    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>

    @GET("products/{productId}")
    suspend fun getProduct(@Path("productId") productId: Long): Response<ProductResponse>

}