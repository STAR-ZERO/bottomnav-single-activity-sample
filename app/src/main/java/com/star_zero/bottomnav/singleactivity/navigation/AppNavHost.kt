package com.star_zero.bottomnav.singleactivity.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.star_zero.bottomnav.singleactivity.ui.account.AccountRoute
import com.star_zero.bottomnav.singleactivity.ui.account.account
import com.star_zero.bottomnav.singleactivity.ui.account.navigateToAccount
import com.star_zero.bottomnav.singleactivity.ui.detail.DetailRoute
import com.star_zero.bottomnav.singleactivity.ui.detail.detail
import com.star_zero.bottomnav.singleactivity.ui.detail.navigateToDetail
import com.star_zero.bottomnav.singleactivity.ui.home.HomeRoute
import com.star_zero.bottomnav.singleactivity.ui.home.home
import com.star_zero.bottomnav.singleactivity.ui.home.navigateToHome
import com.star_zero.bottomnav.singleactivity.ui.login.LoginRoute
import com.star_zero.bottomnav.singleactivity.ui.login.login
import com.star_zero.bottomnav.singleactivity.ui.setting.setting

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = LoginRoute,
        modifier = modifier
    ) {
        login(
            navigateToHome = { navController.navigateToHome() },
            enterTransition = { enterTransitionSlide() },
            exitTransition = { exitTransitionSlide() },
            popEnterTransition = { popEnterTransitionSlide() },
            popExitTransition = { popExitTransitionSlide() }
        )
        home(
            navigateToDetail = { navController.navigateToDetail() },
            enterTransition = {
                if (initialState.destination.route == LoginRoute) {
                    enterTransitionSlide()
                } else {
                    enterTransitionFade()
                }
            },
            exitTransition = {
                if (targetState.destination.route == DetailRoute) {
                    exitTransitionSlide()
                } else {
                    exitTransitionFade()
                }
            },
            popEnterTransition = {
                if (initialState.destination.route == DetailRoute) {
                    popEnterTransitionSlide()
                } else {
                    enterTransitionFade()
                }
            },
            popExitTransition = {
                if (targetState.destination.route == LoginRoute) {
                    popExitTransitionSlide()
                } else {
                    exitTransitionFade()
                }
            },
            nestedGraphs = {
                detail(
                    navigationBack = { navController.popBackStack() },
                    navigateToAccount = { navController.navigateToAccount() },
                    enterTransition = {
                        if (initialState.destination.route == HomeRoute) {
                            enterTransitionSlide()
                        } else {
                            enterTransitionFade()
                        }
                    },
                    exitTransition = {
                        if (targetState.destination.route == AccountRoute) {
                            exitTransitionSlide()
                        } else {
                            exitTransitionFade()
                        }
                    },
                    popEnterTransition = {
                        if (initialState.destination.route == AccountRoute) {
                            popEnterTransitionSlide()
                        } else {
                            enterTransitionFade()
                        }
                    },
                    popExitTransition = {
                        if (targetState.destination.route == HomeRoute) {
                            popExitTransitionSlide()
                        } else {
                            exitTransitionFade()
                        }
                    }
                )
            },
        )
        setting(
            navigateToAccount = {
                navController.navigateToAccount()
            },
            enterTransition = { enterTransitionFade() },
            exitTransition = {
                if (targetState.destination.route == AccountRoute) {
                    exitTransitionSlide()
                } else {
                    exitTransitionFade()
                }
            },
            popEnterTransition = {
                if (initialState.destination.route == AccountRoute) {
                    popEnterTransitionSlide()
                } else {
                    enterTransitionFade()
                }
            },
            popExitTransition = {
                if (targetState.destination.route == LoginRoute) {
                    popExitTransitionSlide()
                } else {
                    exitTransitionSlide()
                }
            }
        )
        account(
            navigationBack = { navController.popBackStack() },
            enterTransition = { enterTransitionSlide() },
            exitTransition = { exitTransitionSlide() },
            popEnterTransition = { popEnterTransitionSlide() },
            popExitTransition = { popExitTransitionSlide() }
        )
    }
}
