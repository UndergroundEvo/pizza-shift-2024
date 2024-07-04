package com.shift.pizzadeliveryapp.data.remote.dto


import com.google.gson.annotations.SerializedName

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