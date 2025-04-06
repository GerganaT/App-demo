package com.example.appdemo.ui.screens.crypto.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appdemo.R
import com.example.appdemo.data.crypto.ui.details.CryptoItemDetailsScreenUiState
import com.example.appdemo.data.crypto.ui.details.CryptoItemDetailsUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoItemDetailsScreen(itemId: Int, onArrowButtonClick: () -> Unit) {

    val viewModel: CryptoItemDetailsScreenViewModel = hiltViewModel()
    val uiState: CryptoItemDetailsScreenUiState by viewModel.uiState.collectAsStateWithLifecycle()

    viewModel.getCryptoItemDetails(itemId)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(id = R.string.crypto_details_title)) },
                navigationIcon = {
                    IconButton(onClick = onArrowButtonClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.back_button_description)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        uiState.details?.let {
            CryptoItemDetails(
                it,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
private fun CryptoItemDetails(details: CryptoItemDetailsUiState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(id = R.dimen.crypto_details_padding_mid))
    ) {
        details.run {
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.symbol_label),
                value = symbol
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.price_change_label),
                value = priceChange
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.price_change_percent_label),
                value = priceChangePercent
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.weighted_avg_price_label),
                value = weightedAvgPrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.prev_close_price_label),
                value = prevClosePrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.last_price_label),
                value = lastPrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.last_qty_label),
                value = lastQty
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.bid_price_label),
                value = bidPrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.bid_qty_label),
                value = bidQty
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.ask_price_label),
                value = askPrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.ask_qty_label),
                value = askQty
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.open_price_label),
                value = openPrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.high_price_label),
                value = highPrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.low_price_label),
                value = lowPrice
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.volume_label),
                value = volume
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.quote_volume_label),
                value = quoteVolume
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.open_time_label),
                value = openTime
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.close_time_label),
                value = closeTime
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.first_id_label),
                value = firstId
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.last_id_label),
                value = lastId
            )
            ItemDetailsUnit(
                propertyLabel = stringResource(id = R.string.count_label),
                value = count
            )
        }
    }
}

@Composable
fun ItemDetailsUnit(propertyLabel: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.crypto_details_padding_xs))
    ) {
        Text(
            text = propertyLabel,
        )
        Text(
            text = value,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.crypto_details_padding_xs))
        )
        HorizontalDivider(
            color = Color.Black
        )
    }
}
