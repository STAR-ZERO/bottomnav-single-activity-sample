package com.star_zero.bottomnav.singleactivity.ui.home

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable

const val HomeGraph = "home_graph"

const val HomeRoute = "home"

fun NavGraphBuilder.home(
    navigateToDetail: () -> Unit,
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
    popEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition),
    popExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition),
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = HomeGraph,
        startDestination = HomeRoute
    ) {
        composable(
            route = HomeRoute,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition,
        ) {
            HomeScreen(
                navigateToDetail = navigateToDetail,
            )
        }

        nestedGraphs()
    }
}

fun NavController.navigateToHome() {
    navigate(HomeRoute)
}
