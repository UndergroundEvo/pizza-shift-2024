package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.shift.pizzadeliveryapp.domain.models.Pizza

data class PizzaDto(
    @SerializedName("allergens")
    val allergens: List<String>,

    @SerializedName("calories")
    val calories: Int,

    @SerializedName("carbohydrates")
    val carbohydrates: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("doughs")
    val doughs: List<Pizza_DoughsDto>,

    @SerializedName("id")
    val id: String,

    @SerializedName("img")
    val img: String,

    @SerializedName("ingredients")
    val ingredients: List<Pizza_IngredientsDto>,

    @SerializedName("isGlutenFree")
    val isGlutenFree: Boolean,

    @SerializedName("isHit")
    val isHit: Boolean,

    @SerializedName("isNew")
    val isNew: Boolean,

    @SerializedName("isVegetarian")
    val isVegetarian: Boolean,

    @SerializedName("name")
    val name: String,

    @SerializedName("protein")
    val protein: String,

    @SerializedName("sizes")
    val sizes: List<Pizza_SizesDto>,

    @SerializedName("sodium")
    val sodium: String,

    @SerializedName("toppings")
    val toppings: List<Pizza_ToppingsDto>,

    @SerializedName("totalFat")
    val totalFat: String
)

fun PizzaDto.toPizza(): Pizza {
    return Pizza(
        id = id,
        name = name,
        ingredients = ingredients.map { it.toPizza_Ingredients() },
        toppings = ingredients.map { it.toPizza_Ingredients() },
        description = description,
        sizes = sizes.map { it.toPizza_Size() },
        dough = doughs.map { it.toPizza_Dough() },
        calories = calories,
        protein = protein,
        totalFat = totalFat,
        carbohydrates = carbohydrates,
        sodium = sodium,
        allergens = allergens,
        isVegetarian = isVegetarian,
        isGlutenFree = isGlutenFree,
        isNew = isNew,
        isHit = isHit,
        img = img
        )
}