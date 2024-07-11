package com.shift.pizzadeliveryapp.data.remote.dto


data class PizzaDto(
    val allergens: List<String>,
    val calories: Int,
    val carbohydrates: String,
    val description: String,
    val doughs: List<PizzaDoughsDto>,
    val id: String,
    val img: String,
    val ingredients: List<PizzaIngredientsDto>,
    val isGlutenFree: Boolean,
    val isHit: Boolean,
    val isNew: Boolean,
    val isVegetarian: Boolean,
    val name: String,
    val protein: String,
    val sizes: List<PizzaSizesDto>,
    val sodium: String,
    val toppings: List<PizzaToppingsDto>,
    val totalFat: String
)