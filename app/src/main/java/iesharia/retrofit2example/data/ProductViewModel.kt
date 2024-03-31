package iesharia.retrofit2example.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import iesharia.retrofit2example.data.network.ProductRepository
import iesharia.retrofit2example.data.network.ProductResponse
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val productsRepository = ProductRepository()

    private val _productList = MutableLiveData<List<ProductResponse>>(emptyList())
    val productList: LiveData<List<ProductResponse>> = _productList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getAllProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            _productList.postValue(productsRepository.getAllProducts().products)
            _isLoading.value = false
        }
    }
}