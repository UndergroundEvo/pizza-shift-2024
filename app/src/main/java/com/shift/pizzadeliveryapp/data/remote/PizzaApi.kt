package com.shift.pizzadeliveryapp.data.remote

import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface PizzaApi {

    @GET("pizza/catalog")
    suspend fun getPizza() : GetCatalogDto

    @POST("auth/otp")
    suspend fun getOtpCode(@Body phone : OtpPhoneDto) : OtpReturnDto

/*    @POST("pizza/payment")
    suspend fun postPayment() //тут еще что-то будет

    @GET("pizza/orders")
    suspend fun getOrders()

    @GET("pizza/orders/{orderId}")
    suspend fun getOrderById(@Path("orderId") orderId: String)

    @PUT("pizza/order/cancel")
    suspend fun putOrderCancel() //и тут тоже*/

}