package com.example.appdemo.di.crypto.api

import com.example.appdemo.api.crypto.CryptoApiService
import com.example.appdemo.api.crypto.CryptoApiUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val CRYPTO_DATA_MAIN_URL = "https://api2.binance.com/api/v3/"

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideInterceptor(): OkHttpClient = HttpLoggingInterceptor().run {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideRetrofit(
        interceptor: OkHttpClient,
        moshi: Moshi,
    ): Retrofit = Retrofit.Builder().addConverterFactory(
        MoshiConverterFactory.create(moshi)
    ).baseUrl(CRYPTO_DATA_MAIN_URL).client(interceptor).build()

    @Provides
    @Singleton
    fun provideCryptoApiService(retrofit: Retrofit): CryptoApiService =
        retrofit.create(CryptoApiService::class.java)

    @Provides
    @Singleton
    fun provideCryptoApiUtil(service: CryptoApiService): CryptoApiUtil = CryptoApiUtil(service)
}
