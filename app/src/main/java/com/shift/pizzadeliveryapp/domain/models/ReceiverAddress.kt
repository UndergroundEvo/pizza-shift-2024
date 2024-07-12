package com.shift.pizzadeliveryapp.domain.models


import com.google.gson.annotations.SerializedName

data class ReceiverAddress(
    val apartment: String,
    val comment: String,
    val house: String,
    val street: String
)