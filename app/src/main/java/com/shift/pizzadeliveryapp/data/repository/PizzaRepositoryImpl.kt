package com.shift.pizzadeliveryapp.data.repository

import com.shift.pizzadeliveryapp.data.remote.PizzaApi
import com.shift.pizzadeliveryapp.data.remote.dto.GetCatalogDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInInputDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInOutputDto
import com.shift.pizzadeliveryapp.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val api: PizzaApi
) : PizzaRepository {

    override suspend fun getPizzas(): GetCatalogDto {
        return api.getPizza()
    }

    override suspend fun getOtpCode(phone: String): OtpReturnDto {
        return api.getOtpCode(OtpPhoneDto(phone))
    }

    override suspend fun signIn(signin: SignInInputDto) : SignInOutputDto {
        return api.signIn(signin)
    }
}