package com.example.appdemo.repository.crypto.local

import com.example.appdemo.data.crypto.db.CryptoDbItem
import com.example.appdemo.db.crypto.CryptoDbItems

interface CryptoLocalSource {
    suspend fun getCryptoItems(): CryptoDbItems

    suspend fun getCryptoItem(id: Int): CryptoDbItem

    suspend fun insertCryptoItems(items: CryptoDbItems)
}
