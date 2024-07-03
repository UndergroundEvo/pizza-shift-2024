package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.shift.pizzadeliveryapp.domain.models.PizzaCatalog

/*
* У некоторых полей данных есть Enum
* типо у размера и т.д.
* как их грамотно использовать в программе?
*/

data class GetCatalogDto(
    @SerializedName("catalog")
    val catalog: List<PizzaDto>,
    @SerializedName("success")
    val success: Boolean
)


//Если смысл засунуть все эти конвертеры в какие-нибудь отдельные файлы?
fun GetCatalogDto.toPizzaCatalog() : PizzaCatalog{
    return PizzaCatalog(
        catalog = catalog.map { it.toPizza() }
    )
}