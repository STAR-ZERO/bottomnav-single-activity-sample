package com.star_zero.bottomnav.singleactivity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.star_zero.bottomnav.singleactivity.navigation.NavigationBarRoutes
import com.star_zero.bottomnav.singleactivity.navigation.NavigationBarTransition
import com.star_zero.bottomnav.singleactivity.navigation.NavigationBarTransitionNone
import com.star_zero.bottomnav.singleactivity.navigation.NavigationBarTransitionNormal
import com.star_zero.bottomnav.singleactivity.navigation.NavigationBarTransitionPop

@Composable
fun rememberAppState(navController: NavController): AppState {
    return remember(navController) {
        AppState(navController)
    }
}

class AppState(
    private val navController: NavController
) {
    private var backStackCount = 0

    private val currentRoute: String?
        @Composable
        get() = navController
            .currentBackStackEntryAsState()
            .value
            ?.destination
            ?.route

    private val currentBackStackCount: Int
        @Composable
        get() = navController
            .currentBackStack
            .collectAsState()
            .value
            .size

    val isShowNavigationBar: Boolean
        @Composable
        get() = NavigationBarRoutes.contains(currentRoute)

    val navigationBarTransition: NavigationBarTransition
        @Composable
        get() {
            val prvCount = backStackCount
            backStackCount = currentBackStackCount

            return if (prvCount == 0) {
                NavigationBarTransitionNone
            } else if (prvCount > currentBackStackCount) {
                // Pop
                NavigationBarTransitionPop
            } else {
                NavigationBarTransitionNormal
            }
        }
}
