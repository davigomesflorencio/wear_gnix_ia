package com.davi.dev.gnixia.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.davi.dev.gnixia.presentation.screens.LoginScreen

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
}

@Composable
fun WearAppNavigator(modifier: Modifier = Modifier) {
    val navController = rememberSwipeDismissableNavController()
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {
        composable(Screen.Login.route) {
            LoginScreen(onLoginClick = { /* TODO: Implement navigation to next screen */ })
        }
    }
}
