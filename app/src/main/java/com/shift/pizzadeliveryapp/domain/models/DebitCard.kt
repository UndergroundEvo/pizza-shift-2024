package com.shift.pizzadeliveryapp.domain.models


import com.google.gson.annotations.SerializedName

data class DebitCard(
    val cvv: String,
    val expireDate: String,
    val pan: String
)