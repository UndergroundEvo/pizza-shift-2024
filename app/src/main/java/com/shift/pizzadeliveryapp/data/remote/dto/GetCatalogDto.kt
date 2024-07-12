package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

/*
* У некоторых полей данных есть Enum
* типо у размера и т.д.
* как их грамотно использовать в программе?
*/

data class GetCatalogDto(
    @SerializedName("catalog")
    val catalog: List<PizzaDto>,
    @SerializedName("success")
    val success: Boolean
)