package com.example.appdemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.appdemo.ui.screens.crypto.details.CryptoItemDetailsScreen
import com.example.appdemo.ui.screens.crypto.items.CryptoItemsScreen

@Composable
fun NavigationHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController, startDestination = Home
    ) {
        composable<Home> {
            CryptoItemsScreen { itemId ->
                navController.navigate(CryptoItemDetails(itemId))
            }
        }
        composable<CryptoItemDetails> { backStackEntry ->
            val cryptoItemDetails: CryptoItemDetails = backStackEntry.toRoute()
            CryptoItemDetailsScreen(itemId = cryptoItemDetails.id,
                onArrowButtonClick = { navController.popBackStack() })
        }
    }
}
