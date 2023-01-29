package com.example.notifications.screen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notifications.MainViewModel
import com.example.notifications.navigation.Screen

@Composable
fun MainScreen(
    navHostController: NavHostController,
    mainVM: MainViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { (mainVM::showSimpleNotification)(context) }) {
            Text(text = "Simple Notification")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { (mainVM::updateSimpleNotification)(context) }) {
            Text(text = "Update Notification")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { mainVM.cancelSimpleNotification() }) {
            Text(text = "Cancel Notification")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navHostController.navigate(
                Screen.Details.passMessage("coming from main screen.")
            )
        }) {
            Text(text = "Details Screen")
        }

    }
}