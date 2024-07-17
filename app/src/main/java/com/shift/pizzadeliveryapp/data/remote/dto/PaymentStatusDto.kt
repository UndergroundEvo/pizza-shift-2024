package com.shift.pizzadeliveryapp.data.remote.dto


data class PaymentStatusDto(
    val orderDto: OrderDto,
    val reason: String,
    val success: Boolean
)