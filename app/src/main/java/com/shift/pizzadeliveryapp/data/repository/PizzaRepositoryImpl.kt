package com.shift.pizzadeliveryapp.data.repository

import com.shift.pizzadeliveryapp.data.remote.PizzaRESTApi
import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import com.shift.pizzadeliveryapp.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val api: PizzaRESTApi
) : PizzaRepository {

    override suspend fun getPizzas(): GetCatalogDto {
        return api.getPizza()
    }

}