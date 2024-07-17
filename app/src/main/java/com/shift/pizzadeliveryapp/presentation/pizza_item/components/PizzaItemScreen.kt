package com.shift.pizzadeliveryapp.presentation.pizza_item.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.common.Constans
import com.shift.pizzadeliveryapp.domain.models.PizzaOrder
import com.shift.pizzadeliveryapp.domain.models.Pizza_Toppings
import com.shift.pizzadeliveryapp.presentation.pizza_item.PizzaItemViewModel
import com.shift.pizzadeliveryapp.presentation.translate.getPizzaSize
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaDough
import com.shift.pizzadeliveryapp.presentation.translate.toRuPizzaSize

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun PizzaItemScreen(
    navController: NavController,
    viewModel: PizzaItemViewModel = hiltViewModel(),
    onAddToBasket: (PizzaOrder) -> Unit
) {
    val state = viewModel.state.value
    //var currentItemSize by remember { mutableStateOf<Pizza_Size?>(null) }
    //var currentDough by remember { mutableStateOf<Pizza_Dough?>(null) }
    var currentToppings = remember { mutableStateListOf<Pizza_Toppings>() }

    var selectedItemSize by rememberSaveable { mutableStateOf(0) }
    var selectedItemDough by rememberSaveable { mutableStateOf(0) }
    val pizzaCost by remember {
        derivedStateOf {
            val toppingsCost = currentToppings.sumOf { it.cost }
            // я не знаю как это доастать не get, не getornull не работают не !!
            val sizeCost = state.pizza?.sizes?.get(selectedItemSize)?.price ?: 1149
            val doughCost = state.pizza?.dough?.get(selectedItemDough)?.price ?: 0
            toppingsCost + sizeCost + doughCost
        }
    }

    Scaffold(
        topBar = { PizzaItemTopBar(navController) },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    //Картинка пиццы
                    AsyncImage(
                        model = Constans.BASE_URL + state.pizza?.img,
                        contentDescription = state.pizza?.name,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(370.dp)
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    ) {
                        Column {
                            Text(
                                text = state.pizza?.name ?: "", //тонкий лед
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                            Text(
                                text =
                                (
                                        getPizzaSize(
                                            name = state.pizza?.sizes?.get(
                                                selectedItemSize
                                            )?.name ?: ""
                                        )

                                                + ", " + stringResource(R.string.dough_word) + " "
                                                + toRuPizzaDough(
                                            name = state.pizza?.dough?.get(
                                                selectedItemDough
                                            )?.name ?: ""
                                        )),
                                //кошмар да?
                                fontSize = 16.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                            Text(
                                text = state.pizza?.description ?: "",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }



                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        SingleChoiceSegmentedButtonRow(
                            modifier = Modifier
                        ) {
                            state.pizza?.sizes?.forEachIndexed { index, pizzaSize ->
                                SegmentedButton(
                                    selected = index == selectedItemSize,
                                    onClick = { selectedItemSize = index },
                                    shape = SegmentedButtonDefaults.itemShape(
                                        index = index,
                                        count = state.pizza.sizes.lastIndex + 1
                                    )
                                ) {
                                    Text(text = toRuPizzaSize(name = pizzaSize.name))
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        SingleChoiceSegmentedButtonRow(
                            modifier = Modifier
                        ) {
                            state.pizza?.dough?.forEachIndexed { index, pizzaDough ->
                                SegmentedButton(
                                    selected = index == selectedItemDough,
                                    onClick = { selectedItemDough = index },
                                    shape = SegmentedButtonDefaults.itemShape(
                                        index = index,
                                        count = state.pizza.sizes.lastIndex
                                    )
                                ) {
                                    Text(text = toRuPizzaDough(name = pizzaDough.name))
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.add_ingr),
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.padding(16.dp))
                    }
                    // тут проблема, нельзя какой-либо grid
                    // ибо все находиться в Collum который скроллиться
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        state.pizza?.toppings?.forEachIndexed { index, pizzaIngredients ->
                            PizzaItemIngredients(
                                ingredients = pizzaIngredients,
                                modifier = Modifier.padding(8.dp),
                                addToPizza = {pizzaIngredients ->
                                    val topping = Pizza_Toppings(
                                        name = pizzaIngredients.name,
                                        cost = pizzaIngredients.cost,
                                        img = pizzaIngredients.img
                                    )
                                    currentToppings.add(topping)
                                }
                            )
                        }
                    }

                }
                Button(
                    onClick = {
                        val pizzaOrder = PizzaOrder(
                            description = "",
                            id = state.pizza?.id!!,
                            name = state.pizza?.name!!,
                            size = state.pizza?.sizes!![selectedItemSize],
                            doughs = state.pizza?.dough!![selectedItemDough],
                            toppings = currentToppings

                        )
                        onAddToBasket(pizzaOrder)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                {
                    Column {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = stringResource(id = R.string.add_to_cart))
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                fontSize = 18.sp,
                                text = pizzaCost.toString() + " ₽"
                            )
                        }
                    }

                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
            )
        }
        if (state.isLoading) {
            Text(
                text = state.error,
            )
        }
    }
}