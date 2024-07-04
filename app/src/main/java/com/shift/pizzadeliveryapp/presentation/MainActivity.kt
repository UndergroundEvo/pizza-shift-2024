package com.shift.pizzadeliveryapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shift.pizzadeliveryapp.presentation.pizza_item.components.PizzaItemScreen
import com.shift.pizzadeliveryapp.presentation.pizza_list.components.PizzaListScreen
import com.shift.pizzadeliveryapp.presentation.theme.PizzaDeliveryAppTheme
import dagger.hilt.android.AndroidEntryPoint

/* TODO
  - Вынести всю навигацию в зависимость
  - перевести все что приходит с бека в data слое
  - поставить пиццы по центру в листе
*/

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PizzaDeliveryAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.PizzaListScreen.route){
                    composable(
                        route = Screen.PizzaListScreen.route
                    ){
                        PizzaListScreen(navController = navController)
                    }
                    composable(
                        route = Screen.PizzaItemScreen.route + "/{pizzaId}"
                    ){
                        PizzaItemScreen(navController = navController)
                    }
                }
            }
        }
    }
}