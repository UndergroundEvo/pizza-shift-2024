package com.shift.pizzadeliveryapp.data.remote

import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.data.remote.dto.PaymentDto
import com.shift.pizzadeliveryapp.data.remote.dto.PaymentStatusDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInInputDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInOutputDto
import com.shift.pizzadeliveryapp.domain.models.Order
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PizzaApi {

    @GET("pizza/catalog")
    suspend fun getPizza() : GetCatalogDto

    @POST("auth/otp")
    suspend fun getOtpCode(@Body phone : OtpPhoneDto) : OtpReturnDto

    @POST("pizza/payment")
    suspend fun postPayment(@Body payment: PaymentDto) : PaymentStatusDto

    @POST("users/signin")
    suspend fun signIn(@Body signin: SignInInputDto) : SignInOutputDto
    /*
    @GET("pizza/orders")
    suspend fun getOrders()

    @GET("pizza/orders/{orderId}")
    suspend fun getOrderById(@Path("orderId") orderId: String)

    @PUT("pizza/order/cancel")
    suspend fun putOrderCancel() //и тут тоже*/

}