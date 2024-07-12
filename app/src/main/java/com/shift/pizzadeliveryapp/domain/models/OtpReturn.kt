package com.shift.pizzadeliveryapp.domain.models

data class OtpReturn(
    val retryDelay: Int,
    val success: Boolean
)