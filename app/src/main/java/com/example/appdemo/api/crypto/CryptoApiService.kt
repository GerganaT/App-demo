package com.example.appdemo.api.crypto

import com.example.appdemo.data.crypto.api.CryptoApiItem
import retrofit2.Response
import retrofit2.http.GET

typealias CryptoItemsResponse = Response<List<CryptoApiItem>>

interface CryptoApiService {
    @GET("ticker/24hr")
    suspend fun getCryptoItems(): CryptoItemsResponse

}

class CryptoApiUtil(apiService: CryptoApiService) {
    private val apiService: CryptoApiService by lazy {
        apiService
    }

    suspend fun getCryptoItems(): CryptoItemsResponse =
        apiService.getCryptoItems()
}
