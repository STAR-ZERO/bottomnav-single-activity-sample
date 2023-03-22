package com.star_zero.bottomnav.singleactivity.ui.login

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

const val LoginRoute = "login"

fun NavGraphBuilder.login(
    navigateToHome: () -> Unit,
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
    popEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    popExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
) {
    composable(
        route = LoginRoute,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
    ) {
        LoginScreen(navigateToHome = navigateToHome)
    }
}
