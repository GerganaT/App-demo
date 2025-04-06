package com.example.appdemo.ui.screens.crypto.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appdemo.R
import com.example.appdemo.data.crypto.ui.items.CryptoItemUiState
import com.example.appdemo.data.crypto.ui.items.CryptoItemsScreenUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoItemsScreen(
    onItemClick: (itemId: Int) -> Unit,
) {
    val viewModel: CryptoItemsScreenViewModel = hiltViewModel()
    val uiState: CryptoItemsScreenUiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        PullToRefreshBox(
            isRefreshing = uiState.isLoading,
            onRefresh = viewModel.onRefresh,
            modifier = Modifier.padding(paddingValues)
        ) {
            if (uiState.isError) {
                ErrorMessageLayout()
            } else {
                CryptoItemsOverview(
                    cryptoItems = uiState.items,
                    onItemClick = onItemClick,
                )
            }
        }
    }
}

@Composable
private fun ErrorMessageLayout(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.error_layout_padding))
            .verticalScroll(
                rememberScrollState()
            ), contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.error_label),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun CryptoItemsOverview(
    cryptoItems: List<CryptoItemUiState>,
    modifier: Modifier = Modifier,
    onItemClick: (itemId: Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.crypto_items_padding))

    ) {
        items(
            items = cryptoItems,
            key = { cryptoItem -> cryptoItem.id },
        ) { cryptoItem ->
            CryptoItem(
                item = cryptoItem,
                onItemClick = onItemClick,
            )
            HorizontalDivider(color = Color.Black)
        }
    }
}

@Composable
private fun CryptoItem(
    item: CryptoItemUiState,
    modifier: Modifier = Modifier,
    onItemClick: (itemId: Int) -> Unit,
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.crypto_item_padding))
            .clickable { onItemClick(item.id) }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = item.symbol)
            Text(
                text = stringResource(
                    id = R.string.price_change_percent_format,
                    item.priceChangePercent,
                )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = stringResource(id = R.string.bid_ask_label))
            Text(
                text = stringResource(
                    id = R.string.bid_ask_price_format,
                    item.bidPrice,
                    item.askPrice,
                )
            )
        }
    }
}
