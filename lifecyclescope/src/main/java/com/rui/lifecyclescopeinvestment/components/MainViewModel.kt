package com.rui.lifecyclescopeinvestment.components

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application
): AndroidViewModel(application) {

    fun launchTaskInViewModelScope() {
        viewModelScope.launch {
            longRunningTask()
        }
    }

    private suspend fun longRunningTask() {
        try {
            delay(5000L)
            Log.d("investLog", "Task completed in viewModelScope")
        } catch (e: CancellationException) {
            Log.d("investLog", "Task canceled in viewModelScope: $e")
        }
    }
}