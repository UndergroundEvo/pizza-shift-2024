package com.shift.pizzadeliveryapp.presentation.translate

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.shift.pizzadeliveryapp.R

@Composable
fun getPizzaSize(name: String) =
    when (name) {
        "SMALL"  -> stringResource(id = R.string.small_size_cm)
        "MEDIUM" -> stringResource(id = R.string.medium_size_cm)
        "LARGE" -> stringResource(id = R.string.large_size_cm)
        else -> stringResource(id = R.string.any_size)
    }