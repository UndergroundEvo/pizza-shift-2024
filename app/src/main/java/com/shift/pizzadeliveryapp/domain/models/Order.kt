package com.shift.pizzadeliveryapp.domain.models


data class Order(
    val debitCard: DebitCard,
    val person: Person,
    val pizzas: MutableList<PizzaOrder>,
    val receiverAddress: ReceiverAddress
)