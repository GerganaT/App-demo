package com.example.appdemo.ui.screens.crypto.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdemo.data.crypto.ui.details.CryptoItemDetailsScreenUiState
import com.example.appdemo.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoItemDetailsScreenViewModel @Inject constructor(
    private val repository: CryptoRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<CryptoItemDetailsScreenUiState> = MutableStateFlow(
        CryptoItemDetailsScreenUiState()
    )

    val uiState: StateFlow<CryptoItemDetailsScreenUiState> = _uiState.asStateFlow()

    val getCryptoItemDetails: (cryptoItemId: Int) -> Unit = { cryptoItemId ->
        viewModelScope.launch {
            repository.getCryptoItemDetails(cryptoItemId).collect { details ->
                _uiState.run {
                    value = value.copy(details = details)
                }
            }
        }
    }
}
