package com.example.appdemo.di.crypto.db

import android.content.Context
import androidx.room.Room
import com.example.appdemo.data.crypto.db.CryptoDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val CRYPTO_DB_NAME = "crypto-db"

@Module
@InstallIn(SingletonComponent::class)
object CryptoDbModule {
    @Provides
    @Singleton
    fun provideCryptoDb(@ApplicationContext context: Context): CryptoDb =
        Room.databaseBuilder(context, CryptoDb::class.java, CRYPTO_DB_NAME).build()

    @Provides
    @Singleton
    fun provideCryptoDao(db: CryptoDb) = db.getCryptoDao()
}
