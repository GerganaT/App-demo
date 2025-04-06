package com.example.appdemo.repository

import com.example.appdemo.data.crypto.api.convertToCryptoDbState
import com.example.appdemo.data.crypto.db.convertToCryptoItemDetailsUiState
import com.example.appdemo.data.crypto.db.convertToCryptoItemUiState
import com.example.appdemo.data.crypto.ui.details.CryptoItemDetailsUiState
import com.example.appdemo.repository.crypto.local.CryptoLocalSource
import com.example.appdemo.repository.crypto.remote.CryptoRemoteSource
import com.example.appdemo.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.flow.onStart

class DefaultCryptoRepository(
    private val remoteSource: CryptoRemoteSource,
    private val localSource: CryptoLocalSource,
) : CryptoRepository {

    override fun getCryptoItemDetails(id: Int): Flow<CryptoItemDetailsUiState> = flow {
        emit(localSource.getCryptoItem(id).convertToCryptoItemDetailsUiState())
    }

    override fun refreshCryptoItems(): Flow<CryptoItemsUiStateResult> = flow {
        remoteSource.getCryptoItemsResult().let { result ->
            if (result is Result.Success) {
                localSource.insertCryptoItems(result.data.mapIndexed { index, item ->
                    //Create id, which starts with 1 as id = 0 would be confusing.
                    //in theory, the "symbol" field of the api response object is unique and can be
                    //converted to numeric value, however, I find this approach quite risky, since
                    //converting letters to numbers can pose some potential issues and corrupt the db
                    item.convertToCryptoDbState(
                        dbItemId = index + 1
                    )
                })
            }
            localSource.getCryptoItems().let { items ->
                if (items.isNotEmpty()) {
                    emit(Result.Success(data = items.map { item -> item.convertToCryptoItemUiState() }))
                } else {
                    emit(Result.Error)
                }
            }
        }
    }.onStart { emit(Result.Loading) }.catch { emit(Result.Error) }
}
