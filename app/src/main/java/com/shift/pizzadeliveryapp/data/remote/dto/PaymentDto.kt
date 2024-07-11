package com.shift.pizzadeliveryapp.data.remote.dto


data class PaymentDto(
    val debitCard: DebitCard,
    val personDto: PersonDto,
    val pizzas: List<PizzaDto>,
    val receiverAddress: ReceiverAddress
)