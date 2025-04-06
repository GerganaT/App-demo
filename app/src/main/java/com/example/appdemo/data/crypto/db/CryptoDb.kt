package com.example.appdemo.data.crypto.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appdemo.db.crypto.CryptoDao

private const val ROOM_DATABASE_VERSION = 1

@Database(entities = [CryptoDbItem::class], version = ROOM_DATABASE_VERSION)
abstract class CryptoDb : RoomDatabase() {
    abstract fun getCryptoDao(): CryptoDao
}
