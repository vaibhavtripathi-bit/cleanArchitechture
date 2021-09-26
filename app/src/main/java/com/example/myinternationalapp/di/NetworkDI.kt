package com.example.myinternationalapp.di

import com.example.myinternationalapp.module.feature_display_localized.data.constant.Constants
import com.example.myinternationalapp.module.feature_display_localized.data.network.apiservices.LocaleApiService
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Network dependency module.
 * Provides Retrofit dependency with OkHttp logger.
 */

val NetworkDependency = module {

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(Constants.BASE_URL)
            .client(provideOkHttpClient())
            .build()
    }
    single { get<Retrofit>().create(LocaleApiService::class.java) }
}

fun provideOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient().newBuilder()
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    builder.addInterceptor(logging)
    return builder.build()
}
