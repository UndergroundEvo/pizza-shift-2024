package com.shift.pizzadeliveryapp.presentation.pizza_item.components


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
