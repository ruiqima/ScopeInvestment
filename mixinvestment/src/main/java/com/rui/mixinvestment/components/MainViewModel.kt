package com.rui.mixinvestment.components


import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application,
    private val coroutineScope: CoroutineScope
): AndroidViewModel(application) {

    var totalJobCount = mutableIntStateOf(0)

    val currentRunningJobs = mutableListOf<String>()

    init {
        viewModelScope.launch {
            while(true) {
                delay(2000L)

            }
        }
    }

    fun launchTaskInCoroutineScope() {
        coroutineScope.launch {
            longRunningTask()
        }
    }

    private suspend fun longRunningTask() {
        totalJobCount.intValue++
        val jobId = totalJobCount.intValue.toString()

        try {
            currentRunningJobs.add(jobId)
            Log.d("investLog", "Job $jobId starts running: $currentRunningJobs")

            delay(7000L)
            currentRunningJobs.remove(jobId)
            Log.d("investLog", "Job $jobId is completed: $currentRunningJobs")

        } catch (e: CancellationException) {
            currentRunningJobs.remove(jobId)
            Log.d("investLog", "Job $jobId is canceled: $currentRunningJobs")
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("investLog", "ViewModel is cleared: $currentRunningJobs")
    }
}