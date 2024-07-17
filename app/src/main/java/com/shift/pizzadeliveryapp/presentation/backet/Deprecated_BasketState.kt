package com.shift.pizzadeliveryapp.presentation.backet

import com.shift.pizzadeliveryapp.domain.models.Order

sealed interface Deprecated_BasketState {
    data object Initial : Deprecated_BasketState

    data object Loading : Deprecated_BasketState

    data class Content(
        var order: Order,
    ) : Deprecated_BasketState

    data class Error(val message: String, var order: Order) : Deprecated_BasketState
}
