package com.star_zero.bottomnav.singleactivity.ui.detail

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

const val DetailRoute = "detail"

fun NavGraphBuilder.detail(
    navigationBack: () -> Unit,
    navigateToAccount: () -> Unit,
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
    popEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    popExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
) {
    composable(
        route = DetailRoute,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
    ) {
        DetailScreen(
            navigationBack = navigationBack,
            navigateToAccount = navigateToAccount
        )
    }
}

fun NavController.navigateToDetail() {
    navigate(DetailRoute)
}
