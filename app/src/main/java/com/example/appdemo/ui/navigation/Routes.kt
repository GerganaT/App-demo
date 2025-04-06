package com.example.appdemo.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class CryptoItemDetails(
    val id: Int,
)
