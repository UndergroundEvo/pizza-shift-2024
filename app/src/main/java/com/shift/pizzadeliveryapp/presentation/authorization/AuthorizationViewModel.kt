package com.shift.pizzadeliveryapp.presentation.authorization

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.data.remote.dto.OtpReturnDto
import com.shift.pizzadeliveryapp.domain.use_case.getOtpCode.GetOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val getOtpReturnUseCase: GetOtpUseCase
) : ViewModel(){

    private val _state = mutableStateOf(AuthorizationState(
        false,
        OtpPhoneDto(""),
        OtpReturnDto(0,false),
        ""
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

}
