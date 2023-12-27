package com.rui.mixinvestment.screens


import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.rui.mixinvestment.components.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ScreenB(
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()

    val viewModel =
        MainViewModel(LocalContext.current.applicationContext as Application, coroutineScope)

    Column {
        Text(text = "Current screen: B")

        Button(onClick = {
            viewModel.launchTaskInCoroutineScope()
        }) {
            Text(text = "Start Job")
        }

        Button(onClick = {
            navController.navigate("A")
            Log.d("investLog", "navigate to screen A")
        }) {
            Text(text = "Navigate back to A")
        }
    }
}