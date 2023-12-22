package com.rui.lifecyclescopeinvestment.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ScreenB(
    navController: NavController
) {
    Column {
        Text(text = "Current screen: B")
        Button(onClick = { navController.navigate("A") }) {
            Log.d("investLog", "navigate to screen A")
            Text(text = "Navigate back to A")
        }
    }
}