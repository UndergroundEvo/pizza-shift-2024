package com.shift.pizzadeliveryapp.presentation.authorization

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInInputDto
import com.shift.pizzadeliveryapp.data.remote.dto.SignInOutputDto
import com.shift.pizzadeliveryapp.data.remote.dto.UserDto
import com.shift.pizzadeliveryapp.domain.usecase.getOtpCode.GetOtpUseCase
import com.shift.pizzadeliveryapp.domain.usecase.signIn.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val getOtpReturnUseCase: GetOtpUseCase,
    private val signInUseCase: SignInUseCase
) : ViewModel(){

    private val _state = mutableStateOf(AuthorizationState(
        false,
        OtpPhoneDto(""),
        OtpReturnDto(0,false),
        "",
        SignInOutputDto(false,"", UserDto("",""))
        )
    )// так имеллось в виду?
     // https://github.com/UndergroundEvo/pizza-shift-2024/pull/1#discussion_r1664609031
    val state: State<AuthorizationState> = _state

    fun onPhoneNumberSubmit(phoneNumber: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            try {
                val response = getOtpReturnUseCase(OtpPhoneDto(phoneNumber))
                if (response.success) {
                    _state.value = state.value.copy(
                        isLoading = false,
                        number = OtpPhoneDto(phoneNumber),
                        otp = response,
                        error = ""
                    )
                } else {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = "Что-то не так"
                    )
                }
            } catch (e: Exception) {
                _state.value = state.value.copy(
                    isLoading = false,
                    error = e.message ?: "e: Exception"
                )
            }
        }
    }

    fun SignInSubmit(signInInputDto: SignInInputDto) {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            try {
                val response = signInUseCase(signInInputDto)
                if (response.success) {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = "",
                        signindata = response
                    )
                } else {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = "Что-то не так"
                    )
                }
            } catch (e: Exception) {
                _state.value = state.value.copy(
                    isLoading = false,
                    error = e.message ?: "e: Exception"
                )
            }
        }
    }

}
