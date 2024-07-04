package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.shift.pizzadeliveryapp.domain.models.Pizza_Toppings

data class Pizza_ToppingsDto(
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String
)

fun Pizza_ToppingsDto.toPizza_Toppings() : Pizza_Toppings {
    return Pizza_Toppings(
        cost = cost,
        img = img,
        name = name
    )
}