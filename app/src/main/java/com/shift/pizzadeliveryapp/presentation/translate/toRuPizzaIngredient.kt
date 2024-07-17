package com.shift.pizzadeliveryapp.presentation.translate

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.data.enums.PizzaIngredient

@Composable
fun toRuPizzaIngredient(name : String) =
    when(name){
        PizzaIngredient.HAM.toString() -> stringResource(id = R.string.ing_ham)
        PizzaIngredient.FETA.toString() -> stringResource(id = R.string.ing_feta)
        PizzaIngredient.BACON.toString() -> stringResource(id = R.string.ing_bacon)
        PizzaIngredient.BASIL.toString() -> stringResource(id = R.string.ing_basil)
        PizzaIngredient.CHILE.toString() -> stringResource(id = R.string.ing_chile)
        PizzaIngredient.CHEDDAR.toString() -> stringResource(id = R.string.ing_cheddar)
        PizzaIngredient.PINEAPPLE.toString() -> stringResource(id = R.string.ing_pineapple)
        PizzaIngredient.MOZZARELLA.toString() -> stringResource(id = R.string.ing_mozzarella)
        PizzaIngredient.PEPERONI.toString() -> stringResource(id = R.string.ing_peperoni)
        PizzaIngredient.GREEN_PEPPER.toString() -> stringResource(id = R.string.ing_green_pepper)
        PizzaIngredient.MUSHROOMS.toString() -> stringResource(id = R.string.ing_mushrooms)
        PizzaIngredient.PARMESAN.toString() -> stringResource(id = R.string.ing_parmesan)
        PizzaIngredient.PICKLE.toString() -> stringResource(id = R.string.ing_pickle)
        PizzaIngredient.TOMATO.toString() -> stringResource(id = R.string.ing_tomato)
        PizzaIngredient.ONION.toString() -> stringResource(id = R.string.ing_onion)
        PizzaIngredient.SHRIMPS.toString() -> stringResource(id = R.string.ing_shrimps)
        PizzaIngredient.CHICKEN_FILLET.toString() -> stringResource(id = R.string.ing_chicken_fillet)
        PizzaIngredient.MEATBALLS.toString() -> stringResource(id = R.string.ing_meatballs)
        else -> stringResource(id = R.string.other_just_word)
    }