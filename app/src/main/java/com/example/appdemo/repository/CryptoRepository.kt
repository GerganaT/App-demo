package com.example.appdemo.repository

import com.example.appdemo.data.crypto.ui.details.CryptoItemDetailsUiState
import com.example.appdemo.data.crypto.ui.items.CryptoItemUiState
import com.example.appdemo.utils.Result
import kotlinx.coroutines.flow.Flow

typealias CryptoItemsUiStateResult = Result<List<CryptoItemUiState>>

interface CryptoRepository {
    fun getCryptoItemDetails(id: Int): Flow<CryptoItemDetailsUiState>

    fun refreshCryptoItems(): Flow<CryptoItemsUiStateResult>
}
