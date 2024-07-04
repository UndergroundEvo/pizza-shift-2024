package com.shift.pizzadeliveryapp.presentation.pizza_item

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.common.Constans
import com.shift.pizzadeliveryapp.common.Resource
import com.shift.pizzadeliveryapp.domain.use_case.get_pizzas.GetPizzaUseCase
import com.shift.pizzadeliveryapp.presentation.pizza_list.PizzaListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PizzaItemViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPizzaUseCase: GetPizzaUseCase
    //как мне можно доставать данные одной пиццы
    //не спрашивая пиццы о всех о всех сразу??7
    // я туп и не придумал как по другому 🤓
    // сохранять определенную пиццу через Room и потом вытягивать (►__◄)
) : ViewModel() {
    private val _state = mutableStateOf(PizzaItemState())
    val state: State<PizzaItemState> = _state

    init {
        savedStateHandle.get<String>(Constans.PIZZA_ID)?.let { pizzaId ->
            getPizza(pizzaId)
        }
    }

    private fun getPizza(pizzaid: String) {
        //Log.i("pizzaId VM", pizzaid.toString())
        getPizzaUseCase().onEach { item ->
            when(item) {
                is Resource.Success -> {
                    val foundPizza = item.data?.catalog?.find { it.id == pizzaid }
                    //Log.i("pizzaId VM Search",_state.value.pizza.id.toString() )
                    _state.value = PizzaItemState(pizza = foundPizza)
                }
                is Resource.Error -> {
                    _state.value = PizzaItemState(error = item.message ?: "Ошибка загрузки элемента")
                }
                is Resource.Loading -> {
                    _state.value = PizzaItemState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}