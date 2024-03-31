package iesharia.retrofit2example

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import iesharia.retrofit2example.data.ProductDBViewModel
import iesharia.retrofit2example.data.ProductViewModel

@Composable
fun ProductListScreen(
    productViewModel: ProductViewModel,
    databaseViewModel: ProductDBViewModel,
    context: Context
) {
    val isLoading: Boolean by productViewModel.isLoading.observeAsState(initial = true)
    if (isLoading) {
        productViewModel.getAllProducts()
        LoadingScreen()
    } else {
        ProductListView("Listado de productos", productViewModel.productList.value!!, databaseViewModel, context)
    }
}