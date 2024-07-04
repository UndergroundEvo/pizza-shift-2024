package com.shift.pizzadeliveryapp.domain.converters

import com.shift.pizzadeliveryapp.R

fun getPizzaSize(name: String) =
    when (name) {
        "SMALL" -> R.string.small_size
        "MEDIUM" -> R.string.medium_size
        "LARGE" -> R.string.large_size

        else -> R.string.any_size
    }