package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.PizzaDoughsDto
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaDough
import com.shift.pizzadeliveryapp.domain.models.Pizza_Dough

fun PizzaDoughsDto.toPizzaDough() : Pizza_Dough {
    return Pizza_Dough(
        name = name,
        price = price
    )
}