package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Pizza_ToppingsDto(
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String
)