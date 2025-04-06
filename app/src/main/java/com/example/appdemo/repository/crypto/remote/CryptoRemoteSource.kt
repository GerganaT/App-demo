package com.example.appdemo.repository.crypto.remote

import com.example.appdemo.data.crypto.api.CryptoApiItem
import com.example.appdemo.utils.Result

typealias CryptoApiItemsResult = Result<List<CryptoApiItem>>

interface CryptoRemoteSource {
    suspend fun getCryptoItemsResult(): CryptoApiItemsResult
}
