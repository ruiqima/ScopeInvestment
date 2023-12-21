package com.rui.scopeinvestment.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlin.coroutines.cancellation.CancellationException

@Composable
fun ScreenA(
    navController: NavController
) {
        Column {
            Text(text = "Current screen: A")
            Button(onClick = { navController.navigate("B") }) {
                println("navigate to screen B")
                Text(text = "Navigate to B")
            }
        }


    LaunchedEffect(Unit){
        try {
            longRunningTask()
            println("Task completed in LaunchedEffect")
        } catch (e: CancellationException) {
            println("Task canceled in LaunchedEffect: $e")
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            println("Composable ScreenA leaves the composition")
        }
    }
}

suspend fun longRunningTask() {
    delay(5000L)
}