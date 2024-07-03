package com.shift.pizzadeliveryapp.presentation

sealed class Screen(val route: String) {
    object PizzaListScreen: Screen("pizza_list_screen")
    //object PizzaDetailScreen: Screen("coin_detail_screen")
}