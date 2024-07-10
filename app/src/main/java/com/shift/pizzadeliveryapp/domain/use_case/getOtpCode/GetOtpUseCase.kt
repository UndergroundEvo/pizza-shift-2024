package com.shift.pizzadeliveryapp.domain.use_case.getOtpCode

import com.shift.pizzadeliveryapp.data.remote.PizzaApi
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import javax.inject.Inject

class GetOtpUseCase @Inject constructor(
    //private val repository: PizzaRepository,
    private val api: PizzaApi
) {
    suspend operator fun invoke(phoneNumber: OtpPhoneDto): OtpReturnDto {
        return api.getOtpCode(phoneNumber)
    }
}