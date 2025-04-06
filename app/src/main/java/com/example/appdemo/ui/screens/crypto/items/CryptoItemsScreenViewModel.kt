package com.example.appdemo.ui.screens.crypto.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdemo.data.crypto.ui.items.CryptoItemsScreenUiState
import com.example.appdemo.repository.CryptoItemsUiStateResult
import com.example.appdemo.repository.CryptoRepository
import com.example.appdemo.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoItemsScreenViewModel @Inject constructor(
    private val repository: CryptoRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<CryptoItemsScreenUiState> = MutableStateFlow(
        CryptoItemsScreenUiState()
    )
    val uiState: StateFlow<CryptoItemsScreenUiState> = _uiState.asStateFlow()

    init {
        refreshCryptoItems()
    }

    val onRefresh: () -> Unit = {
        refreshCryptoItems()
    }

    private fun refreshCryptoItems() {
        viewModelScope.launch {
            repository.refreshCryptoItems().collect { result ->
                handleCryptoItemsResult(result)
            }
        }
    }

    private fun handleCryptoItemsResult(result: CryptoItemsUiStateResult) {
        _uiState.run {
            value = when (result) {
                is Result.Success -> value.copy(
                    items = result.data, isLoading = false, isError = false
                )

                is Result.Loading -> value.copy(isLoading = true)
                is Result.Error -> value.copy(isError = true, isLoading = false)
            }
        }
    }
}
