package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class OtpReturnDto(
    //@SerializedName("retryDelay")
    val retryDelay: Int,
    //@SerializedName("success")
    val success: Boolean
)