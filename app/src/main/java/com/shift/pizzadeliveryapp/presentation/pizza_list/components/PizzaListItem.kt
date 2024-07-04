package com.shift.pizzadeliveryapp.presentation.pizza_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.common.Constans
import com.shift.pizzadeliveryapp.domain.models.Pizza

@Composable
fun PizzaListItem(
    pizza: Pizza,
    onItemClick: (Pizza) -> Unit
) {
    Card(
        onClick = { onItemClick(pizza) },
        modifier = Modifier
            .fillMaxWidth(),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Row {
            AsyncImage(
                model = Constans.BASE_URL + pizza.img,
                contentDescription = pizza.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(16.dp)
                    .size(140.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = pizza.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = pizza.description,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = stringResource(id = R.string.min_price)
                            + pizza.sizes[0].price.toString() + "₽",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}