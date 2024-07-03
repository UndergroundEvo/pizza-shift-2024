package com.shift.pizzadeliveryapp.domain.repository

import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto

interface PizzaRepository {

    suspend fun getPizzas() : GetCatalogDto
}