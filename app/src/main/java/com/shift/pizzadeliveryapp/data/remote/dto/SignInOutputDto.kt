package com.shift.pizzadeliveryapp.data.remote.dto


data class SignInOutputDto(
    val success: Boolean,
    val token: String,
    val userDto: UserDto
)