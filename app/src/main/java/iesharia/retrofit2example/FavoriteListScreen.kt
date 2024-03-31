package iesharia.retrofit2example

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import iesharia.retrofit2example.data.ProductDBViewModel
import iesharia.retrofit2example.data.network.productToProductResponse

@Composable
fun FavoriteListScreen(databaseViewModel: ProductDBViewModel, context: Context) {
    val favoriteList = databaseViewModel.getFavoriteProductList().collectAsState(initial = emptyList())
    val convertedList = favoriteList.value.map { productToProductResponse(it) }
    val isLoading: Boolean by databaseViewModel.isLoading.observeAsState(initial = false)
    if (isLoading) {
        LoadingScreen()
    } else {
        FavoriteListView("Listado de productos favoritos", convertedList, databaseViewModel, context)
    }
}