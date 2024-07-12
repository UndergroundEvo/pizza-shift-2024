package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Pizza_DoughsDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)