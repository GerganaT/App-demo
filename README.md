This is a demo app, demonstrating the items below:

Implemented MVVM architectural pattern to support the following functionalities:
- Fetch remote data from https://api2.binance.com/api/v3/ticker/24hr
- Persist the fetched data to the device even in offline mode
- Added two screens - CryptoItemsScreen and CryptoItemDetailsScreen
  # CryptoItemsScreen
  - Shows brief overview of crypto items trading statistics 
  - If the data cannot be fetched, an error-screen, with possibility for the user to refresh the data, appears
  - Pull-down-to-refresh widget with loading indicator to get the newest crypto data.
  # CryptoItemDetailsScreen
  - View crypto item full details, triggered upon clicking any item from the list in CryptoItemsScreen

# Libraries used:  
 - Hilt -dependency injection - allows for easy-to-maintain and less error-prone dependency management
 - Kotlin coroutines and Flow - performance improvement, especially for computation-intensive operations
 - Compose - easy and performant UI creation and screen navigation
 - Retrofit with Moshi for retrieving the data from the Web and converting it to Kotlin objects
 - OkHttp3 logging interceptor to record the status of any server data requests
 - Room for data persistence
