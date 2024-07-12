package com.shift.pizzadeliveryapp.presentation.pizza_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.common.Resource
import com.shift.pizzadeliveryapp.domain.use_case.get_pizzas.GetPizzaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PizzaListViewModel @Inject constructor(
    private val getPizzaUseCase: GetPizzaUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PizzaListState())
    val state: State<PizzaListState> = _state

    init {
        getPizza()
    }

    private fun getPizza(){
        getPizzaUseCase().onEach { item ->
            when(item) {
                is Resource.Success -> {
                    _state.value = PizzaListState(pizza = item.data?.catalog ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PizzaListState(
                        error = item.message ?: R.string.item_error.toString()
                    )
                }
                is Resource.Loading -> {
                    _state.value = PizzaListState(
                        error = item.message ?: R.string.item_load.toString()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}