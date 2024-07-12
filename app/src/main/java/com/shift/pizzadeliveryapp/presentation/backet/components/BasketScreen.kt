package com.shift.pizzadeliveryapp.presentation.backet.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.presentation._common.BottonNavigationBar
import com.shift.pizzadeliveryapp.presentation.backet.BasketViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketScreen(
    navController: NavController,
    viewModel: BasketViewModel/* = hiltViewModel()*/
) {

    val basket by viewModel.basket

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.shopping_cart))
                })
        },
        bottomBar = { BottonNavigationBar(navController = navController) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Column {
                LazyColumn(userScrollEnabled = true) {
                    items(items = basket.order.pizzas) { item ->
                        PizzaItemBasket(pizza = item)
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                CheckoutPanel(basket.order)
            }
        }
    }
}