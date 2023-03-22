package com.star_zero.bottomnav.singleactivity.ui.account

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

const val AccountRoute = "account"

fun NavGraphBuilder.account(
    navigationBack: () -> Unit,
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
    popEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    popExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
) {
    composable(
        route = AccountRoute,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition
    ) {
        AccountScreen(
            navigationBack = navigationBack
        )
    }
}

fun NavController.navigateToAccount() {
    navigate(AccountRoute)
}
