package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SignInOutputDto(
    val success: Boolean,
    val token: String,
    val user: User
)