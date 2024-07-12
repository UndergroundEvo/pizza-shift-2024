package com.shift.pizzadeliveryapp.presentation

import androidx.compose.ui.graphics.vector.ImageVector

// эта штука должна быть в presentation слое?
data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val route: String
)
