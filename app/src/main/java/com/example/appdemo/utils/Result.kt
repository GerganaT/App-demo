package com.example.appdemo.utils

/** General-purpose class for expressing different data states */
sealed class Result<out T : Any> {

    data object Loading : Result<Nothing>()

    data class Success<out T : Any>(
        val data: T,
    ) : Result<T>()

    data object Error : Result<Nothing>() {
        var errorMessage: String? = null
    }
}
