package com.shift.pizzadeliveryapp.presentation

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.shift.pizzadeliveryapp.R

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun BottonNavigationBar() {
    val items = listOf(
        BottomNavigationItem(
            title = stringResource(R.string.topAppBar_name),
            icon = ImageVector.vectorResource(R.drawable.baseline_local_pizza_24),
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            title = stringResource(R.string.orders),
            icon = ImageVector.vectorResource(R.drawable.baseline_access_time_24),
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            title = stringResource(R.string.shopping_cart),
            icon = ImageVector.vectorResource(R.drawable.baseline_shopping_basket_24),
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            title = stringResource(R.string.profile),
            icon = ImageVector.vectorResource(R.drawable.baseline_account_circle_24),
            hasNews = false,
            badgeCount = null
        )
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    /*navController.navigate(NavigationKeys.MAIN_AFISHA)*/
                },
                label = { Text(text = item.title) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(imageVector = item.icon, contentDescription = item.title)
                    }
                }
            )

        }
    }
}