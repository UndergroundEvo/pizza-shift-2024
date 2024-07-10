package com.shift.pizzadeliveryapp.domain.repository

import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import retrofit2.http.Field

interface PizzaRepository {

    suspend fun getPizzas() : GetCatalogDto
    suspend fun getOtpCode(phone : String) : OtpReturnDto
}