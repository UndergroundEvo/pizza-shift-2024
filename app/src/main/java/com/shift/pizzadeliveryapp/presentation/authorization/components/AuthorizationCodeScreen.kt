package com.shift.pizzadeliveryapp.presentation.authorization.components

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.data.remote.dto.OtpPhoneDto
import com.shift.pizzadeliveryapp.presentation._common.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationCodeScreen(
    navController: NavController,
    phone: OtpPhoneDto
){
    var code by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.authorization_text)) },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.arrow_back)
                        )
                    }
                },
                actions = {
                    OpenCodeLink()
                }
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
                Text(text = stringResource(id = R.string.text_enter_code))
                Spacer(modifier = Modifier.padding(4.dp))
                Spacer(modifier = Modifier.padding(12.dp))
                OutlinedTextField(
                    value = phone.phone,
                    onValueChange = { phone.phone },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    //readOnly = true,
                    enabled = false
                    //visualTransformation = Vi
                )
                Spacer(modifier = Modifier.padding(12.dp))
                Text(text = stringResource(id = R.string.text_code))
                Spacer(modifier = Modifier.padding(12.dp))
                OutlinedTextField(
                    value = code,
                    onValueChange = { code = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Button(
                    onClick = { }
                ) {
                    Text(text = stringResource(id = R.string.continue_text))
                }

            }


        }

    }
}