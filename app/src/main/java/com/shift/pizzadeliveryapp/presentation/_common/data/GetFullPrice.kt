package com.shift.pizzadeliveryapp.presentation._common.data

import com.shift.pizzadeliveryapp.domain.models.Order
import com.shift.pizzadeliveryapp.domain.models.PizzaOrder
import com.shift.pizzadeliveryapp.domain.models.Pizza_Toppings

fun GetFullPrice(order: Order) : Int{
    var price : Int  = 0
    order.pizzas.forEach { pizzaOrder: PizzaOrder ->
        price += pizzaOrder.size.price
        price += pizzaOrder.doughs.price
        pizzaOrder.toppings.forEach { toppings: Pizza_Toppings ->
            price += toppings.cost
        }
    }
    return price
}