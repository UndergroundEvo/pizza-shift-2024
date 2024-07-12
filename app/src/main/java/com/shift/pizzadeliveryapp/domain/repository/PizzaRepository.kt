package com.shift.pizzadeliveryapp.domain.repository

import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInInputDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInOutputDto
import retrofit2.http.Body

interface PizzaRepository {

    suspend fun getPizzas() : GetCatalogDto
    suspend fun getOtpCode(phone : String) : OtpReturnDto
    suspend fun signIn(signin: SignInInputDto) : SignInOutputDto
}