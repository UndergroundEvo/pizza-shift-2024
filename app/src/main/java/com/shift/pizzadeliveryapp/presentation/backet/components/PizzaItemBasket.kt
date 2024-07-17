package com.shift.pizzadeliveryapp.presentation.backet.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.domain.models.PizzaOrder
import com.shift.pizzadeliveryapp.presentation.translate.getPizzaSize
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaDough
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaIngredient
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaSize

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PizzaItemBasket(pizza: PizzaOrder) {
    Card(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth(),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Row {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = pizza.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(8.dp))
                FlowRow {
                    Text(
                        text = toRuPizzaSize(pizza.size.name) + " (" +
                                getPizzaSize(pizza.size.name) + "), "
                    )
                    Text(text = toRuPizzaDough(name = pizza.doughs.name) + " "
                            + stringResource(id = R.string.dough_word) + ", ")
                    pizza.toppings.forEach { toppings ->
                        Text(text = toRuPizzaIngredient(name = toppings.name) + ", ")
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
            }

        }
    }
}