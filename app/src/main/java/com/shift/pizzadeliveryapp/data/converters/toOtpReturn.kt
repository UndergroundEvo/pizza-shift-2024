package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.domain.models.OtpReturn

fun OtpReturnDto.toOtpReturn(): OtpReturn{
    return OtpReturn(
        retryDelay = retryDelay,
        success = success
    )
}