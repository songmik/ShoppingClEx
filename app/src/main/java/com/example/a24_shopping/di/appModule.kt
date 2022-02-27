package com.example.a24_shopping.di

import android.preference.PreferenceManager
import com.example.a24_shopping.data.network.buildOkHttpClient
import com.example.a24_shopping.data.network.provideProductApiService
import com.example.a24_shopping.data.network.provideProductRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single { provideGsonConverterFactory() }
    single { buildOkHttpClient() }
    single { provideProductRetrofit(get(), get()) }
    single { provideProductApiService(get()) }
}