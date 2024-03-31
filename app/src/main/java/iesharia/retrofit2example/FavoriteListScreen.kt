package iesharia.retrofit2example

import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import iesharia.retrofit2example.data.network.ProductResponse

@Composable
fun FavoriteListScreen() {
    ProductListView("Listado de productos favoritos", MutableLiveData<List<ProductResponse>>(emptyList()))
}