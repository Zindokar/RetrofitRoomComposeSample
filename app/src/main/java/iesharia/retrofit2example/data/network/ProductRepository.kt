package iesharia.retrofit2example.data.network

class ProductRepository {
    val api = ProductService()

    suspend fun getAllProducts(): ProductsResponse {
        return api.getAllProducts()
    }
}