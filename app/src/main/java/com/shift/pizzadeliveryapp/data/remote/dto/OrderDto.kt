package com.shift.pizzadeliveryapp.data.remote.dto


data class OrderDto(
    val cancellable: Boolean,
    val personDto: PersonDto,
    val receiverAddress: ReceiverAddress,
    val status: Int
)