package com.shift.pizzadeliveryapp.presentation

sealed class Screen(val route: String) {
    object PizzaListScreen: Screen("pizza_list_screen")
    object PizzaItemScreen: Screen("pizza_item_screen")
    object AuthorizationScreen: Screen("authorization_screen")
}