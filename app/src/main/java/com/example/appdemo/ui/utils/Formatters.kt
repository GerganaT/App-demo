package com.example.appdemo.ui.utils

import android.icu.text.SimpleDateFormat
import android.util.Log
import java.util.Date
import java.util.Locale

private const val DATE_HOUR_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss"
private const val DATE_FORMATTER_EXCEPTION_TAG = "Formatters, formatToDateHour"

fun Long.formatToDateHourOrNull(): String? = try {
    SimpleDateFormat(DATE_HOUR_FORMAT_PATTERN, Locale.getDefault()).format(
        Date(this)
    )
} catch (exception: Exception) {
    exception.message?.let { Log.e(DATE_FORMATTER_EXCEPTION_TAG, it) }
    null
}
