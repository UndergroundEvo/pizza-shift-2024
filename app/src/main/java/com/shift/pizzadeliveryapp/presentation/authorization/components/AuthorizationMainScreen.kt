package com.shift.pizzadeliveryapp.presentation.authorization.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.presentation._common.LoadingIndicator
import com.shift.pizzadeliveryapp.presentation.authorization.AuthorizationViewModel

@Composable
fun AuthorizationScreen(
    viewModel: AuthorizationViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value

    fun getNumber(): OtpPhoneDto {
        return state.number
    }

    when {
        state.isLoading -> {
            LoadingIndicator()
        }
        state.error != "" -> {
            Text(
                text = state.error,
            )
        }
        state.otp != OtpReturnDto(0,false) -> {
            AuthorizationCodeScreen(
                navController = navController,
                phone = state.number
            ) // Покажите экран для ввода кода OTP и таймер
        }
        else -> {
            AuthorizationPhoneScreen(
                navController = navController,
                onPhoneNumberSubmit = { phoneNumber -> viewModel.onPhoneNumberSubmit(phoneNumber)}
            )
        }
    }
}