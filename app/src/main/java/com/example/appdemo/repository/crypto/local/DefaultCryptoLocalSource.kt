package com.example.appdemo.repository.crypto.local

import com.example.appdemo.data.crypto.db.CryptoDbItem
import com.example.appdemo.db.crypto.CryptoDao
import com.example.appdemo.db.crypto.CryptoDbItems

class DefaultCryptoLocalSource(
    private val cryptoDao: CryptoDao
) : CryptoLocalSource {
    override suspend fun getCryptoItems(): CryptoDbItems = cryptoDao.getCryptoItems()

    override suspend fun getCryptoItem(id: Int): CryptoDbItem = cryptoDao.getCryptoItem(id)

    override suspend fun insertCryptoItems(items: CryptoDbItems) {
        cryptoDao.insertCryptoItems(items)
    }
}
