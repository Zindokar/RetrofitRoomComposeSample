package iesharia.retrofit2example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import iesharia.retrofit2example.data.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = true)
    if (isLoading) {
        viewModel.getAllProducts()
        LoadingScreen()
    } else {
        ProductListView("Listado de productos", viewModel.productList)
    }
}