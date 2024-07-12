package com.shift.pizzadeliveryapp.data.converters

import com.shift.pizzadeliveryapp.data.remote.dto.PizzaDto
import com.shift.pizzadeliveryapp.domain.models.Pizza

fun PizzaDto.toPizza(): Pizza {
    return Pizza(
        id = id,
        name = name,
        ingredients = ingredients.map { it.toPizza_Ingredients() },
        toppings = toppings.map { it.toPizza_Toppings() },
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