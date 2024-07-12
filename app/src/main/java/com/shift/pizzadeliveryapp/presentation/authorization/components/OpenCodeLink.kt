package com.shift.pizzadeliveryapp.presentation.authorization.components

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.shift.pizzadeliveryapp.R

@Composable
fun OpenCodeLink() {
    val context = LocalContext.current
    val openLink =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == android.app.Activity.RESULT_OK) {
            }
        }
    IconButton(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://shift-backend.onrender.com/otps")
            openLink.launch(intent)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.MailOutline,
            contentDescription = stringResource(id = R.string.topAppBar_name)
        )
    }
}