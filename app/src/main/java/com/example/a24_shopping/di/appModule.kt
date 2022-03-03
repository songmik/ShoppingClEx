package com.example.a24_shopping.di

import com.example.a24_shopping.data.db.provideDB
import com.example.a24_shopping.data.db.provideToDoDao
import com.example.a24_shopping.data.network.buildOkHttpClient
import com.example.a24_shopping.data.network.provideGsonConverterFactory
import com.example.a24_shopping.data.network.provideProductApiService
import com.example.a24_shopping.data.network.provideProductRetrofit
import com.example.a24_shopping.data.preference.PreferenceManager
import com.example.a24_shopping.data.repository.DefaultProductRepository
import com.example.a24_shopping.data.repository.ProductRepository
import com.example.a24_shopping.domain.product.DeleteOrderedProductListUseCase
import com.example.a24_shopping.domain.product.GetOrderedProductListUseCase
import com.example.a24_shopping.domain.product.GetProductItemUseCase
import com.example.a24_shopping.domain.product.OrderProductItemUseCase
import com.example.a24_shopping.presentation.detail.ProductDetailViewModel
import com.example.a24_shopping.presentation.list.ProductListViewModel
import com.example.a24_shopping.presentation.main.MainViewModel
import com.example.a24_shopping.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {

    //coroutine
    single { Dispatchers.Main }
    single { Dispatchers.IO }

    //viewModel
    viewModel { MainViewModel() }
    viewModel { ProductListViewModel(get())}
    viewModel { ProfileViewModel(get(),get(),get()) }
    viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(),get()) }

    //UseCase
    factory { GetProductItemUseCase(get()) }
    factory { GetOrderedProductListUseCase(get()) }
    factory { GetProductItemUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }
    factory { DeleteOrderedProductListUseCase(get()) }

    //Repositories
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    single { provideGsonConverterFactory() }
    single { buildOkHttpClient() }
    single { provideProductRetrofit(get(), get()) }
    single { provideProductApiService(get()) }
    single { PreferenceManager(androidContext()) }

    //Database
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }
}