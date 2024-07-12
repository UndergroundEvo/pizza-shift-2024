package com.shift.pizzadeliveryapp.presentation.authorization

import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto

data class AuthorizationState(
    val isLoading: Boolean = false,
    var number : OtpPhoneDto,
    var otp : OtpReturnDto,
    val error: String
)
