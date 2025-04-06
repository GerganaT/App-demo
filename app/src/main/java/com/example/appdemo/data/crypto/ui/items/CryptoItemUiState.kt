package com.example.appdemo.data.crypto.ui.items

data class CryptoItemUiState(
    val id: Int,
    val symbol: String,
    val priceChangePercent: Double,
    val bidPrice: Double,
    val askPrice: Double,
)
