package com.shift.pizzadeliveryapp.presentation.pizza_item.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shift.pizzadeliveryapp.domain.models.Pizza
import com.shift.pizzadeliveryapp.domain.models.Pizza_Size


//не додумал как отслеживать из вне
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaSizeSelectButtonRow(
    size: List<Pizza_Size>,
    selectedItemIndex: Int
){
    var innerItemIndex by rememberSaveable { mutableStateOf(selectedItemIndex) }

    SingleChoiceSegmentedButtonRow(
        modifier = Modifier
    ) {
        size.forEachIndexed{ index, pizzaSize ->
            SegmentedButton(selected = index == selectedItemIndex,
                onClick = { innerItemIndex = index },
                shape = SegmentedButtonDefaults.itemShape(index = index, count = size.lastIndex+1)
            ) {
                Text(text = pizzaSize.name)
            }
        }
    }
}*/
