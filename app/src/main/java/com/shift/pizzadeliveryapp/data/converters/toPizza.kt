package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.PizzaDto
import com.shift.pizzadeliveryapp.domain.models.Pizza

fun PizzaDto.toPizza(): Pizza {
    return Pizza(
        id = id,
        name = name,
        ingredients = ingredients.map { it.toPizzaIngredients() },
        toppings = toppings.map { it.toPizzaToppings() },
        description = description,
        sizes = sizes.map { it.toPizzaSize() },
        dough = doughs.map { it.toPizzaDough() },
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