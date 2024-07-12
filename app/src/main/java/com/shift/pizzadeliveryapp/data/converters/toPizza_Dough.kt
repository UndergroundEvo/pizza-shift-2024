package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.Pizza_DoughsDto
import com.shift.pizzadeliveryapp.domain.models.Pizza_Dough

fun Pizza_DoughsDto.toPizza_Dough() : Pizza_Dough {
    return Pizza_Dough(
        name = name,
        price = price
    )
}