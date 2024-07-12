package com.shift.pizzadeliveryapp.presentation.translate

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.data.enums.PizzaSize

@Composable
fun toRuPizzaSize(name : String) =
    when(name){
        PizzaSize.SMALL.toString() -> stringResource(id = R.string.pizza_small)
        PizzaSize.MEDIUM.toString() -> stringResource(id = R.string.pizza_medium)
        PizzaSize.LARGE.toString() -> stringResource(id = R.string.pizza_large)
        else -> stringResource(id = R.string.any_size)
    }
