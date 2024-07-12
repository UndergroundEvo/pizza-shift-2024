package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.Pizza_ToppingsDto
import com.shift.pizzadeliveryapp.domain.models.Pizza_Toppings


fun Pizza_ToppingsDto.toPizza_Toppings() : Pizza_Toppings {
    return Pizza_Toppings(
        cost = cost,
        img = img,
        name = name
    )
}