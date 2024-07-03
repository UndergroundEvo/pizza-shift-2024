package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.shift.pizzadeliveryapp.domain.models.Pizza_Size

data class Pizza_SizesDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)

fun Pizza_SizesDto.toPizza_Size() : Pizza_Size{
    return Pizza_Size(
        name = name,
        price = price
    )
}