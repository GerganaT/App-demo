package com.example.appdemo.data.crypto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appdemo.data.crypto.ui.details.CryptoItemDetailsUiState
import com.example.appdemo.data.crypto.ui.items.CryptoItemUiState
import com.example.appdemo.ui.utils.formatToDateHourOrNull
import com.example.appdemo.utils.EMPTY_DOUBLE_VALUE
import com.example.appdemo.utils.NA_TEXT

private const val CRYPTO_ITEMS_TABLE = "crypto-items"

@Entity(tableName = CRYPTO_ITEMS_TABLE)
data class CryptoDbItem(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "symbol")
    val symbol: String,
    @ColumnInfo(name = "price-change")
    val priceChange: String,
    @ColumnInfo(name = "price-change-percent")
    val priceChangePercent: String,
    @ColumnInfo(name = "weighted-avg-price")
    val weightedAvgPrice: String,
    @ColumnInfo(name = "prev-close-price")
    val prevClosePrice: String,
    @ColumnInfo(name = "last-price")
    val lastPrice: String,
    @ColumnInfo(name = "last-qty")
    val lastQty: String,
    @ColumnInfo(name = "bid-price")
    val bidPrice: String,
    @ColumnInfo(name = "bid-qty")
    val bidQty: String,
    @ColumnInfo(name = "ask-price")
    val askPrice: String,
    @ColumnInfo(name = "ask-qty")
    val askQty: String,
    @ColumnInfo(name = "open-price")
    val openPrice: String,
    @ColumnInfo(name = "high-price")
    val highPrice: String,
    @ColumnInfo(name = "low-price")
    val lowPrice: String,
    @ColumnInfo(name = "volume")
    val volume: String,
    @ColumnInfo(name = "quote-volume")
    val quoteVolume: String,
    @ColumnInfo(name = "open-time")
    val openTime: Long,
    @ColumnInfo(name = "close-time")
    val closeTime: Long,
    @ColumnInfo(name = "first-id")
    val firstId: Long,
    @ColumnInfo(name = "last-id")
    val lastId: Long,
    @ColumnInfo(name = "count")
    val count: Int,
)

fun CryptoDbItem.convertToCryptoItemUiState() = CryptoItemUiState(
    id,
    symbol,
    priceChangePercent.toDoubleOrNull() ?: EMPTY_DOUBLE_VALUE,
    bidPrice.toDoubleOrNull() ?: EMPTY_DOUBLE_VALUE,
    askPrice.toDoubleOrNull() ?: EMPTY_DOUBLE_VALUE,
)

fun CryptoDbItem.convertToCryptoItemDetailsUiState() = CryptoItemDetailsUiState(
    id,
    symbol,
    priceChange,
    priceChangePercent,
    weightedAvgPrice,
    prevClosePrice,
    lastPrice,
    lastQty,
    bidPrice,
    bidQty,
    askPrice,
    askQty,
    openPrice,
    highPrice,
    lowPrice,
    volume,
    quoteVolume,
    openTime.formatToDateHourOrNull() ?: NA_TEXT,
    closeTime.formatToDateHourOrNull() ?: NA_TEXT,
    firstId.toString(),
    lastId.toString(),
    count.toString(),
)
