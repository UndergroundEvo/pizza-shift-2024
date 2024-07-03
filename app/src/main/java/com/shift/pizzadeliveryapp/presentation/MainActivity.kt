package com.shift.pizzadeliveryapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shift.pizzadeliveryapp.presentation.pizza_list.components.PizzaListScreen
import com.shift.pizzadeliveryapp.presentation.theme.PizzaDeliveryAppTheme
import dagger.hilt.android.AndroidEntryPoint

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
                }
            }
        }
    }
}