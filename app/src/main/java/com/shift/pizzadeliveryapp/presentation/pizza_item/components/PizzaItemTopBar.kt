package com.shift.pizzadeliveryapp.presentation.pizza_item.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.shift.pizzadeliveryapp.R

// чую что этой штуке скоро стоит уехать от сюда
// много где еще topbar будет
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaItemTopBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.topAppBar_name)) },
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.arrow_back)
                )
            }
        }
    )
}