package com.shift.pizzadeliveryapp.domain.usecase.placeorder

import com.shift.pizzadeliveryapp.data.remote.PizzaApi
import com.shift.pizzadeliveryapp.data.remote.dto.PaymentDto
import com.shift.pizzadeliveryapp.data.remote.dto.PaymentStatusDto
import javax.inject.Inject

class PlaceOrderUseCase @Inject constructor(
    private val api: PizzaApi
) {
    suspend operator fun invoke(payment: PaymentDto): PaymentStatusDto {
        return api.postPayment(payment)
    }
}