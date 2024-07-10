package com.shift.pizzadeliveryapp.domain.models

data class OtpReturn(
    //@SerializedName("retryDelay")
    val retryDelay: Int,
    //@SerializedName("success")
    val success: Boolean
)