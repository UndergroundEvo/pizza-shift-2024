package com.shift.pizzadeliveryapp.data.remote.dto


data class PizzaSizesDto(
    val name: String,
    val price: Int
)

// я чета туплю и не понимаю как можно все переводить
// исходя из языка приложения
/*fun Pizza_SizesToRu(name: String) =
    when (name) {
        "SMALL" -> R.string.pizza_small
        "MEDIUM" -> R.string.pizza_medium.toString()
        "LARGE" -> R.string.pizza_large.toString()
        else -> "Другой"
    }*/