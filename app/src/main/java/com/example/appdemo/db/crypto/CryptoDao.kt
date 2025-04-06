package com.example.appdemo.db.crypto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appdemo.data.crypto.db.CryptoDbItem

typealias CryptoDbItems = List<CryptoDbItem>

@Dao
interface CryptoDao {
    @Query("SELECT * FROM 'crypto-items'")
    suspend fun getCryptoItems(): CryptoDbItems

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptoItems(items: CryptoDbItems)

    @Query("SELECT * FROM 'crypto-items' WHERE id = :id")
    suspend fun getCryptoItem(id: Int): CryptoDbItem
}
