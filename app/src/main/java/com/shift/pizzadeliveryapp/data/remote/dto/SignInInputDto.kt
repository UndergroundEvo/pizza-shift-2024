package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SignInInputDto(
    val code: Int,
    val phone: String
)