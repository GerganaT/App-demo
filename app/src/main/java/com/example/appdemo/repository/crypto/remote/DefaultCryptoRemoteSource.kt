package com.example.appdemo.repository.crypto.remote

import android.util.Log
import com.example.appdemo.api.crypto.CryptoApiUtil
import com.example.appdemo.utils.Result

private const val CRYPTO_ITEMS_RESPONSE_LIMIT = 100

class DefaultCryptoRemoteSource(
    private val apiUtil: CryptoApiUtil,
) : CryptoRemoteSource {

    override suspend fun getCryptoItemsResult(): CryptoApiItemsResult = try {
        apiUtil.getCryptoItems().let { response ->
            if (response.isSuccessful) {
                response.body()
                    // no server-side option to decrease data size, done to better performance
                    ?.let { items -> Result.Success(items.take(CRYPTO_ITEMS_RESPONSE_LIMIT)) }
                    ?: Result.Error
            } else {
                Result.Error
            }
        }
    } catch (exception: Exception) {
        Result.Error.apply {
            exception.message?.let { message ->
                errorMessage = message
                Log.e(DefaultCryptoRemoteSource::class.simpleName, message)
            }
        }
    }
}
