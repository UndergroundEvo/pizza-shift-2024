package com.shift.pizzadeliveryapp.domain.use_case.getOtpCode

import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.common.Resource
import com.shift.pizzadeliveryapp.data.converters.toOtpReturn
import com.shift.pizzadeliveryapp.data.converters.toPizzaCatalog
import com.shift.pizzadeliveryapp.data.remote.PizzaApi
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.domain.models.OtpReturn
import com.shift.pizzadeliveryapp.domain.models.PizzaCatalog
import com.shift.pizzadeliveryapp.domain.repository.PizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetOtpUseCase @Inject constructor(
    //private val repository: PizzaRepository,
    private val api: PizzaApi
) {
    suspend operator fun invoke(phoneNumber: OtpPhoneDto): OtpReturnDto {
        return api.getOtpCode(phoneNumber)
    }
}