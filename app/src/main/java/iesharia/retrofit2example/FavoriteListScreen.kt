package iesharia.retrofit2example

import android.content.Context
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import iesharia.retrofit2example.data.ProductDBViewModel
import iesharia.retrofit2example.data.db.productResponseToProduct
import iesharia.retrofit2example.network.ProductResponse
import iesharia.retrofit2example.network.productToProductResponse

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

@Composable
fun FavoriteListView(
    title: String,
    favoriteList: List<ProductResponse>,
    databaseViewModel: ProductDBViewModel,
    context: Context
) {
    ProductList(title, favoriteList, Icons.Filled.Delete) { product: ProductResponse ->
        Toast.makeText(context, "Producto eliminado", Toast.LENGTH_SHORT).show()
        databaseViewModel.deleteFavoriteProduct(productResponseToProduct(product).id)
    }
}