package com.rui.mixinvestment.screens


import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun ScreenA(
    navController: NavController
) {

    Column {
        Text(text = "Current screen: A")

        Button(onClick = {
            navController.navigate("B")
            Log.d("investLog", "navigate to screen B")
        }) {
            Text(text = "Navigate to B")
        }
    }
}