package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SignInFailDto(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("success")
    val success: Boolean
)