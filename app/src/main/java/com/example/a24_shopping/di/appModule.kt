package com.example.a24_shopping.di

import com.example.a24_shopping.data.network.buildOkHttpClient
import com.example.a24_shopping.data.network.provideGsonConverterFactory
import com.example.a24_shopping.data.network.provideProductApiService
import com.example.a24_shopping.data.network.provideProductRetrofit
import com.example.a24_shopping.data.repository.DefaultProductRepository
import com.example.a24_shopping.data.repository.ProductRepository
import com.example.a24_shopping.domain.product.GetProductItemUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {

    //coroutine
    single { Dispatchers.Main }
    single { Dispatchers.IO }

    //UseCase
    factory { GetProductItemUseCase(get()) }

    //Repositories
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    single { provideGsonConverterFactory() }
    single { buildOkHttpClient() }
    single { provideProductRetrofit(get(), get()) }
    single { provideProductApiService(get()) }
}