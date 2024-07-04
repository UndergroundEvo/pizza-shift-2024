package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.Pizza_SizesDto
import com.shift.pizzadeliveryapp.domain.models.Pizza_Size

fun Pizza_SizesDto.toPizza_Size() : Pizza_Size {
    return Pizza_Size(
        name = name,
        price = price
    )
}