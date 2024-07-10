package com.shift.pizzadeliveryapp.presentation.pizza_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shift.pizzadeliveryapp.presentation.BottonNavigationBar
import com.shift.pizzadeliveryapp.presentation.Screen
import com.shift.pizzadeliveryapp.presentation.pizza_list.PizzaListViewModel

@Composable
fun PizzaListScreen(
    navController: NavController,
    viewModel: PizzaListViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Scaffold(
        topBar = { PizzaListTopBar() },
        bottomBar = { BottonNavigationBar(navController) }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
        ) {
            //это можно будет поменять что-бы попробовать сделать что-то вроде версии для планшета
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.pizza){pizza ->
                    PizzaListItem(
                        pizza,
                        onItemClick = {navController.navigate(Screen.PizzaItemScreen.route + "/${pizza.id}")
                        }
                    )
                }
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
            )
        }
        if(state.isLoading) {
            Text(
                text = state.error,
            )
        }
    }
}