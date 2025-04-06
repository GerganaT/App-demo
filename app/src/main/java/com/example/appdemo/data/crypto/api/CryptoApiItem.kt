package com.example.appdemo.data.crypto.api

import com.example.appdemo.data.crypto.db.CryptoDbItem
import com.example.appdemo.utils.EMPTY_INT_VALUE
import com.example.appdemo.utils.EMPTY_LONG_VALUE
import com.example.appdemo.utils.EMPTY_TEXT
import com.example.appdemo.utils.EMPTY_VALUE_TEXT

data class CryptoApiItem(
    val symbol: String?,
    val priceChange: String?,
    val priceChangePercent: String?,
    val weightedAvgPrice: String?,
    val prevClosePrice: String?,
    val lastPrice: String?,
    val lastQty: String?,
    val bidPrice: String?,
    val bidQty: String?,
    val askPrice: String?,
    val askQty: String?,
    val openPrice: String?,
    val highPrice: String?,
    val lowPrice: String?,
    val volume: String?,
    val quoteVolume: String?,
    val openTime: Long?,
    val closeTime: Long?,
    val firstId: Long?,
    val lastId: Long?,
    val count: Int?,
)

fun CryptoApiItem.convertToCryptoDbState(dbItemId: Int) = CryptoDbItem(
    dbItemId,
    symbol ?: EMPTY_TEXT,
    priceChange ?: EMPTY_VALUE_TEXT,
    priceChangePercent ?: EMPTY_VALUE_TEXT,
    weightedAvgPrice ?: EMPTY_VALUE_TEXT,
    prevClosePrice ?: EMPTY_VALUE_TEXT,
    lastPrice ?: EMPTY_VALUE_TEXT,
    lastQty ?: EMPTY_VALUE_TEXT,
    bidPrice ?: EMPTY_VALUE_TEXT,
    bidQty ?: EMPTY_VALUE_TEXT,
    askPrice ?: EMPTY_VALUE_TEXT,
    askQty ?: EMPTY_VALUE_TEXT,
    openPrice ?: EMPTY_VALUE_TEXT,
    highPrice ?: EMPTY_VALUE_TEXT,
    lowPrice ?: EMPTY_VALUE_TEXT,
    volume ?: EMPTY_VALUE_TEXT,
    volume ?: EMPTY_VALUE_TEXT,
    openTime ?: EMPTY_LONG_VALUE,
    closeTime ?: EMPTY_LONG_VALUE,
    firstId ?: EMPTY_LONG_VALUE,
    lastId ?: EMPTY_LONG_VALUE,
    count ?: EMPTY_INT_VALUE,
)
