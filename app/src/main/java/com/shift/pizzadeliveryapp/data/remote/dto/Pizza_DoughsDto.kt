package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.shift.pizzadeliveryapp.domain.models.Pizza_Dough

data class Pizza_DoughsDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)

fun Pizza_DoughsDto.toPizza_Dough() : Pizza_Dough{
    return Pizza_Dough(
        name = name,
        price = price
    )
}