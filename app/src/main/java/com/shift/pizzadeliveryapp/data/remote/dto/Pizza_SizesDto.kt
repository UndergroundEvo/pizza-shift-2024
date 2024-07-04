package com.shift.pizzadeliveryapp.data.remote.dto



import androidx.core.content.ContextCompat.getString
import com.google.gson.annotations.SerializedName
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.domain.models.Pizza_Size

data class Pizza_SizesDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
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

fun Pizza_SizesDto.toPizza_Size() : Pizza_Size{
    return Pizza_Size(
        name = name,
        price = price
    )
}