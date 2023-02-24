package uz.gita.mytestproject.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import uz.gita.mytestproject.data.response.ProductData

interface ProductApi {

    @GET("v1/offers")
    suspend fun getData() : Response<ProductData>
}