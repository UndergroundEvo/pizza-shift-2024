package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import com.shift.pizzadeliveryapp.domain.models.PizzaCatalog

fun GetCatalogDto.toPizzaCatalog() : PizzaCatalog {
    return PizzaCatalog(
        catalog = catalog.map { it.toPizza() }
    )
}