package com.rui.mixinvestment.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "A") {
        composable("A") { ScreenA(navController) }
        composable("B") { ScreenB(navController) }
    }
}
