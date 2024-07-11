package com.shift.pizzadeliveryapp.data.remote.dto


data class GetCatalogDto(
    val catalog: List<PizzaDto>,
    val success: Boolean
)