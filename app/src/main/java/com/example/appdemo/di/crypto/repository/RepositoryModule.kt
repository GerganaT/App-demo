package com.example.appdemo.di.crypto.repository

import com.example.appdemo.api.crypto.CryptoApiUtil
import com.example.appdemo.db.crypto.CryptoDao
import com.example.appdemo.repository.CryptoRepository
import com.example.appdemo.repository.DefaultCryptoRepository
import com.example.appdemo.repository.crypto.local.CryptoLocalSource
import com.example.appdemo.repository.crypto.local.DefaultCryptoLocalSource
import com.example.appdemo.repository.crypto.remote.CryptoRemoteSource
import com.example.appdemo.repository.crypto.remote.DefaultCryptoRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCryptoRemoteSource(apiUtil: CryptoApiUtil): CryptoRemoteSource =
        DefaultCryptoRemoteSource(apiUtil)

    @Provides
    @Singleton
    fun provideCryptoLocalSource(cryptoDao: CryptoDao): CryptoLocalSource =
        DefaultCryptoLocalSource(cryptoDao)

    @Provides
    @Singleton
    fun provideCryptoRepository(
        remoteSource: CryptoRemoteSource,
        localSource: CryptoLocalSource
    ): CryptoRepository =
        DefaultCryptoRepository(remoteSource, localSource)
}
