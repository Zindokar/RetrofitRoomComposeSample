package iesharia.retrofit2example.data.network

import retrofit2.Response
import retrofit2.http.GET

interface ProductClient {
    @GET("/products")
    suspend fun getAllProducts(): Response<ProductsResponse>

    @GET("/product/{id}")
    suspend fun getProductById(id: Int): Response<ProductResponse>
}