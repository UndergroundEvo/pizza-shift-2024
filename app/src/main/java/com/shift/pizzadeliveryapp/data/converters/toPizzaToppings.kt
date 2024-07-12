package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.PizzaToppingsDto
import com.shift.pizzadeliveryapp.domain.models.Pizza_Toppings


fun PizzaToppingsDto.toPizzaToppings() : Pizza_Toppings {
    return Pizza_Toppings(
        cost = cost,
        img = img,
        name = name
    )
}