package com.shift.pizzadeliveryapp.presentation.pizza_list

import com.shift.pizzadeliveryapp.domain.models.Pizza

data class PizzaListState(
    val isLoading: Boolean = false,
    val pizza: List<Pizza> = emptyList(),
    val error: String = ""
)
