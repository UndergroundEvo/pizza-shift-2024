package com.shift.pizzadeliveryapp.presentation.authorization

import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInOutputDto

data class AuthorizationState(
    val isLoading: Boolean = false,
    var number : OtpPhoneDto,
    var otp : OtpReturnDto,
    val error: String,
    val signindata: SignInOutputDto
)
