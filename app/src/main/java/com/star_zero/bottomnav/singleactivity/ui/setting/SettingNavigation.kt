package com.star_zero.bottomnav.singleactivity.ui.setting

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

const val SettingRoute = "setting"

fun NavGraphBuilder.setting(
    navigateToAccount: () -> Unit,
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
    popEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    popExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
) {
    composable(
        route = SettingRoute,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
    ) {
        SettingScreen(
            navigateToAccount = navigateToAccount
        )
    }
}
