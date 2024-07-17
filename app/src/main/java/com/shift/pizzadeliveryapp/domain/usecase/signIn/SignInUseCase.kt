package com.shift.pizzadeliveryapp.domain.usecase.signIn

import com.shift.pizzadeliveryapp.data.remote.PizzaApi
import com.shift.pizzadeliveryapp.data.remote.dto.SignInInputDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInOutputDto
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val api: PizzaApi
) {
    suspend operator fun invoke(signin: SignInInputDto): SignInOutputDto {
        return api.signIn(signin)
    }
}