package com.shift.pizzadeliveryapp.presentation.pizza_item.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.shift.pizzadeliveryapp.common.Constans
import com.shift.pizzadeliveryapp.domain.models.Pizza_Toppings
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaIngredient
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaSize

@Composable
fun PizzaItemIngredients(
    ingredients: Pizza_Toppings,
    modifier: Modifier,
    addToPizza: (Pizza_Toppings) -> Unit
) {
    ElevatedCard(
        onClick = {
            addToPizza(ingredients)
        },
        modifier = Modifier.size(120.dp, 200.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            focusedElevation = 30.dp,
            pressedElevation = 100.dp
        )
    ) {
        Column {
            OutlinedCard(
                onClick = {},
                modifier = Modifier.padding(4.dp)
            ) {
                AsyncImage(
                    model = Constans.BASE_URL + ingredients.img,
                    contentDescription = ingredients.name,

                    )
            }
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = toRuPizzaIngredient(name = ingredients.name),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                )
            }
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = ingredients.cost.toString() + " ₽",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                )
            }


        }
    }

}
