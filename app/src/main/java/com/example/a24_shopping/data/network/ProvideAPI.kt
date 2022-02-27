package com.example.a24_shopping.data.network

import com.example.a24_shopping.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal fun provideProductApiService(retrofit: Retrofit): ProductApiService {
    return retrofit.create(ProductApiService::class.java)
}

internal fun provideProductRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory,
):Retrofit{
    return Retrofit.Builder()
        .baseUrl(Url.PRODUCT_BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}

internal fun buildOkHttpClient(): OkHttpClient{
    val interceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG){
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        interceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}