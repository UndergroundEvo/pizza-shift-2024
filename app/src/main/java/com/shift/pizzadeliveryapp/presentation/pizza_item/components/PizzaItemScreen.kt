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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.shift.pizzadeliveryapp.domain.converters.getPizzaSize
import com.shift.pizzadeliveryapp.presentation.pizza_item.PizzaItemViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun PizzaItemScreen(
    navController: NavController,
    viewModel: PizzaItemViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var selectedItemSize by rememberSaveable { mutableStateOf(0) }
    var selectedItemDough by rememberSaveable { mutableStateOf(0) }


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
                    AsyncImage(
                        model = Constans.BASE_URL + state.pizza?.img,
                        //alignment = Alignment.TopCenter,
                        contentDescription = state.pizza?.name,
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(370.dp)
                    )
                }
                //Spacer(modifier = Modifier.padding(8.dp))
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
                                text = stringResource(
                                    id = getPizzaSize(
                                        state.pizza?.sizes?.get(selectedItemSize)?.name ?: ""
                                    )
                                ) + ", " + stringResource(R.string.dough_word) + " "
                                + state.pizza?.dough?.get(selectedItemDough)?.name
                                    ?: "", //кошмар да?
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
                                    Text(text = pizzaSize.name)
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
                                    Text(text = pizzaDough.name)
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
                                modifier = Modifier.padding(8.dp)
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