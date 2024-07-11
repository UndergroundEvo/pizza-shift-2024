package com.shift.pizzadeliveryapp.data.remote.dto


data class DebitCard(
    val cvv: String,
    val expireDate: String,
    val pan: String
)