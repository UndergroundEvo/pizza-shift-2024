package com.shift.pizzadeliveryapp.presentation.authorization.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.presentation.BottonNavigationBar
import com.shift.pizzadeliveryapp.presentation._common.TopBar

@Composable
fun AuthorizationPhoneScreen(
    navController: NavController,
    onPhoneNumberSubmit: (String) -> Unit,

){
    var phone by rememberSaveable { mutableStateOf("") }

    Scaffold(
        //bottomBar = { BottonNavigationBar(navController) }
        topBar = {
            TopBar(
                navController = navController,
                name = stringResource(id = R.string.authorization_text)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = stringResource(id = R.string.text_enter_phone))
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = stringResource(id = R.string.phone_example_text),
                    fontSize = 13.sp,
                    modifier = Modifier.alpha(0.2f)
                )
                Spacer(modifier = Modifier.padding(12.dp))
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    //visualTransformation = Vi
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Button(
                    onClick = {
                        onPhoneNumberSubmit(phone)

                    }
                ) {
                    Text(text = stringResource(id = R.string.continue_text))
                    
                }
            }


        }

    }
}