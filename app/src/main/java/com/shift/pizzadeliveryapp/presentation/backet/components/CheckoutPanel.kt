package com.shift.pizzadeliveryapp.presentation.backet.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.domain.models.Order
import com.shift.pizzadeliveryapp.domain.models.PizzaOrder
import com.shift.pizzadeliveryapp.presentation._common.data.GetFullPrice

@Composable
fun CheckoutPanel(order: Order) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 9.dp,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.order_cost) + GetFullPrice(order) + " ₽"
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                   Text(
                       modifier = Modifier.padding(8.dp),
                       fontSize = 17.sp,
                       text = stringResource(id = R.string.checkout)
                   )
                }
            }
        }
    }
}