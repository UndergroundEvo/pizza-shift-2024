package com.shift.pizzadeliveryapp.domain.models


import com.google.gson.annotations.SerializedName

data class Order(
    val debitCard: DebitCard,
    val person: Person,
    val pizzas: MutableList<PizzaOrder>,
    val receiverAddress: ReceiverAddress
)