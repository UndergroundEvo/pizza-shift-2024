package com.shift.pizzadeliveryapp.data.remote

import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PizzaRESTApi {

    @GET("pizza/catalog")
    suspend fun getPizza() : GetCatalogDto

/*    @POST("pizza/payment")
    suspend fun postPayment() //тут еще что-то будет

    @GET("pizza/orders")
    suspend fun getOrders()

    @GET("pizza/orders/{orderId}")
    suspend fun getOrderById(@Path("orderId") orderId: String)

    @PUT("pizza/order/cancel")
    suspend fun putOrderCancel() //и тут тоже*/

}