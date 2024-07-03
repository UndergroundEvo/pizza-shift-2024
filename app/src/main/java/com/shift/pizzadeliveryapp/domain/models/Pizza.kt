package com.shift.pizzadeliveryapp.domain.models

data class Pizza(
    val id: String,
    val name: String,

    val ingredients: List<Pizza_Ingredients>,
    val toppings: List<Pizza_Ingredients>,
    val description: String,
    val sizes: List<Pizza_Size>,
    val dough: List<Pizza_Dough>,

    val calories: Int,
    val protein: String,
    val totalFat: String,
    val carbohydrates: String,
    val sodium: String,
    val allergens: List<String>,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isNew: Boolean,
    val isHit: Boolean,
    val img: String
)
