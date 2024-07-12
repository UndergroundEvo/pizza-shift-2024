package com.shift.pizzadeliveryapp.domain.models


data class DebitCard(
    val cvv: String,
    val expireDate: String,
    val pan: String
)