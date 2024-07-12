package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.Pizza_IngredientsDto
import com.shift.pizzadeliveryapp.domain.models.Pizza_Ingredients

fun Pizza_IngredientsDto.toPizza_Ingredients() : Pizza_Ingredients {
    return Pizza_Ingredients(
        cost = cost,
        img = img,
        name = name
    )
}