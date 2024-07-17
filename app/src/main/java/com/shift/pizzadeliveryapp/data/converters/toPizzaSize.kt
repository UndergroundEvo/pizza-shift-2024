package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.PizzaSizesDto
import com.shift.pizzadeliveryapp.domain.models.Pizza_Size

fun PizzaSizesDto.toPizzaSize() : Pizza_Size {
    return Pizza_Size(
        name = name,
        price = price
    )
}