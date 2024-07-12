package com.shift.pizzadeliveryapp.presentation.translate

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.data.enums.PizzaDough

@Composable
fun toRuPizzaDough(name: String) =
    when (name) {
        PizzaDough.THIN.toString() -> stringResource(id = R.string.dough_thin)
        PizzaDough.THICK.toString() -> stringResource(id = R.string.dough_thick)
        else -> stringResource(id = R.string.other_just_word)
    }