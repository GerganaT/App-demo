package com.example.appdemo.data.crypto.ui.items

data class CryptoItemsScreenUiState(
    val items: List<CryptoItemUiState> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
