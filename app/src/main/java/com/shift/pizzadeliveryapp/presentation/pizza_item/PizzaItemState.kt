package com.shift.pizzadeliveryapp.presentation.pizza_item

import com.shift.pizzadeliveryapp.domain.models.Pizza

data class PizzaItemState (
    val isLoading: Boolean = false,
    //val pizzas: List<Pizza> = emptyList(),
    val pizza: Pizza? = null,
    val error: String = ""
)