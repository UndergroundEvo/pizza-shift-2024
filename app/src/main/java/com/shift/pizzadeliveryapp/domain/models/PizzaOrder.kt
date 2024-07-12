package com.shift.pizzadeliveryapp.domain.models


data class PizzaOrder(
    val description: String, //коментарий к готовке пиццы
    val doughs: Pizza_Dough,
    val id: String,
    val name: String,
    val size: Pizza_Size,
    val toppings: MutableList<Pizza_Toppings>
)