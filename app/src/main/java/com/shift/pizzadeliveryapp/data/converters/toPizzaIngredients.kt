package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.PizzaIngredientsDto
import com.shift.pizzadeliveryapp.domain.models.Pizza_Ingredients

fun PizzaIngredientsDto.toPizzaIngredients() : Pizza_Ingredients {
    return Pizza_Ingredients(
        cost = cost,
        img = img,
        name = name
    )
}