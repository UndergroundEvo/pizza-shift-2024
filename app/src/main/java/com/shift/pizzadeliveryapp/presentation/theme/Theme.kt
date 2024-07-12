package com.shift.pizzadeliveryapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFF4511E),
    secondary = Color(0xFFF4511E),
    tertiary = Color(0xFFF4511E),
    //Other default colors to override

    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),

    onPrimary = Color.White, //текст на кнопках
    onSecondary = Color.White,
    onTertiary = Color.White,

    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),

    secondaryContainer = Color.White,
    onSecondaryContainer = Color(0xFFF4511E)

)

@Composable
fun PizzaDeliveryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}