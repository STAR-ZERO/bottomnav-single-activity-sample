package com.star_zero.bottomnav.singleactivity.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavBackStackEntry

private const val DefaultDeuration = 300

sealed class NavigationBarTransition(
    val enterTransition: EnterTransition,
    val exitTransition: ExitTransition
)

object NavigationBarTransitionNone : NavigationBarTransition(
    enterTransition = EnterTransition.None,
    exitTransition = ExitTransition.None,
)

object NavigationBarTransitionNormal : NavigationBarTransition(
    enterTransition = slideInHorizontally(tween(DefaultDeuration)) { it },
    exitTransition = slideOutHorizontally(tween(DefaultDeuration)) { -it },
)

object NavigationBarTransitionPop : NavigationBarTransition(
    enterTransition = slideInHorizontally(tween(DefaultDeuration)) { -it },
    exitTransition = slideOutHorizontally(tween(DefaultDeuration)) { it },
)

fun AnimatedContentScope<NavBackStackEntry>.enterTransitionSlide(): EnterTransition {
    return slideIntoContainer(
        AnimatedContentScope.SlideDirection.Left,
        tween(DefaultDeuration)
    )
}

fun AnimatedContentScope<NavBackStackEntry>.exitTransitionSlide(): ExitTransition {
    return slideOutOfContainer(
        AnimatedContentScope.SlideDirection.Left,
        tween(DefaultDeuration)
    )
}

fun AnimatedContentScope<NavBackStackEntry>.popEnterTransitionSlide(): EnterTransition {
    return slideIntoContainer(
        AnimatedContentScope.SlideDirection.Right,
        tween(DefaultDeuration)
    )
}

fun AnimatedContentScope<NavBackStackEntry>.popExitTransitionSlide(): ExitTransition {
    return slideOutOfContainer(
        AnimatedContentScope.SlideDirection.Right,
        tween(DefaultDeuration)
    )
}

fun enterTransitionFade(): EnterTransition {
    return fadeIn(
        tween(DefaultDeuration)
    )
}

fun exitTransitionFade(): ExitTransition {
    return fadeOut(
        tween(DefaultDeuration)
    )
}
