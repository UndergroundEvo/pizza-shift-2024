package com.shift.pizzadeliveryapp.data.remote.dto


data class OtpReturnDto(
    //@SerializedName("retryDelay")
    val retryDelay: Int,
    //@SerializedName("success")
    val success: Boolean
)