package com.rui.lifecyclescopeinvestment.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.rui.lifecyclescopeinvestment.components.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

@Composable
fun ScreenA(
    navController: NavController
) {
    val viewModel = MainViewModel(LocalContext.current.applicationContext as Application)

    val coroutineScope = rememberCoroutineScope()

    Column {
        Text(text = "Current screen: A")
        Button(onClick = {
            coroutineScope.launch { longRunningTask() }
        }) {
            Text(text = "Start task in coroutineScope")
        }
        Button(onClick = {
            viewModel.launchTaskInViewModelScope()
        }) {
            Text(text = "Start task in viewModelScope")
        }
        Button(onClick = {
            navController.navigate("B")
            Log.d("investLog", "navigate to screen B")
        }) {
            Text(text = "Navigate to B")
        }
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
        Log.d("investLog", "Task completed in rememberCoroutineScope")
    } catch (e: CancellationException) {
        Log.d("investLog", "Task canceled in rememberCoroutineScope: $e")
    }
}