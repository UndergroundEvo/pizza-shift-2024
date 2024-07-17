package com.shift.pizzadeliveryapp.presentation.backet

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.shift.pizzadeliveryapp.domain.models.DebitCard
import com.shift.pizzadeliveryapp.domain.models.Order
import com.shift.pizzadeliveryapp.domain.models.Person
import com.shift.pizzadeliveryapp.domain.models.PizzaOrder
import com.shift.pizzadeliveryapp.domain.models.ReceiverAddress
import javax.inject.Inject

class BasketViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    /*
    private val _state = MutableStateFlow<Deprecated_BasketState>(Deprecated_BasketState.Initial)
    val state: StateFlow<Deprecated_BasketState> = _state.asStateFlow()*/

    private val _basket = mutableStateOf(
        BasketState(
            Order(
                debitCard = DebitCard("", "", ""),
                person = Person("", "", "", ""),
                pizzas = mutableListOf(),
                receiverAddress = ReceiverAddress("", "", "", "")
            )
        )
    )
    val basket: State<BasketState> = _basket


    fun addPizzaToBasket(pizza: PizzaOrder) {
        basket.value.order.pizzas.add(pizza)
    }
    fun removePizzaFromBasket(pizza: PizzaOrder) {
        _basket.value.order.pizzas.remove(pizza)
    }

    /*fun placeOrder() {
        viewModelScope.launch {
            val result = placeOrderUseCase(_basket.value)
            if (result.isSuccess) {
                // Обработка успешного заказа
                _basket.value = Order(
                    debitCard = DebitCard("", "", ""),
                    person = Person("", "", "", ""),
                    pizzas = mutableListOf(),
                    receiverAddress = ReceiverAddress("", "", "", "")
                )
            } else {
                // Обработка ошибки при заказе
            }
        }
    }*/

}