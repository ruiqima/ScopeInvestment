package com.rui.scopeinvestment.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
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
            Button(onClick = {
                navController.navigate("B")
                Log.d("investLog", "navigate to screen B")
            }) {
                Text(text = "Navigate to B")
            }
        }


    LaunchedEffect(Unit){
        longRunningTask()
    }

    DisposableEffect(Unit) {
        Log.d("investLog", "Composable ScreenA enters the composition")
        onDispose {
            Log.d("investLog", "Composable ScreenA leaves the composition")
        }
    }
}

suspend fun longRunningTask() {
    try {
        delay(5000L)
        Log.d("investLog", "Task completed in LaunchedEffect")
    } catch (e: CancellationException) {
        Log.d("investLog", "Task canceled in LaunchedEffect: $e")
    }
}