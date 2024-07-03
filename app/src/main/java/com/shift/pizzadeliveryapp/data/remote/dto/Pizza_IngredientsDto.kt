package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.shift.pizzadeliveryapp.domain.models.Pizza_Ingredients

data class Pizza_IngredientsDto(
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String
)

fun Pizza_IngredientsDto.toPizza_Ingredients() : Pizza_Ingredients{
    return Pizza_Ingredients(
        cost = cost,
        img = img,
        name = name
    )
}