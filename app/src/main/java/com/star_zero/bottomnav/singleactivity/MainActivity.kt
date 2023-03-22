package com.star_zero.bottomnav.singleactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.star_zero.bottomnav.singleactivity.navigation.AppNavHost
import com.star_zero.bottomnav.singleactivity.navigation.NavigationBarDestination
import com.star_zero.bottomnav.singleactivity.ui.theme.BottomNavSingleActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpEdgeToEdge()

        setContent {
            BottomNavSingleActivityTheme {
                val navController = rememberAnimatedNavController()

                val appState = rememberAppState(navController)

                Box(modifier = Modifier.fillMaxSize()) {
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.fillMaxSize()
                    )

                    var selectedIndex by rememberSaveable { mutableStateOf(0) }
                    val navigationBarTransition = appState.navigationBarTransition
                    AnimatedVisibility(
                        visible = appState.isShowNavigationBar,
                        enter = navigationBarTransition.enterTransition,
                        exit = navigationBarTransition.exitTransition,
                        modifier = Modifier.align(Alignment.BottomCenter),
                    ) {
                        AppBottomBar(
                            navController = navController,
                            selectedIndex = selectedIndex,
                            onChangeNavigationBar = { selectedIndex = it }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppBottomBar(
    navController: NavController,
    selectedIndex: Int,
    onChangeNavigationBar: (Int) -> Unit
) {
    NavigationBar {
        NavigationBarDestination.values().forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    onChangeNavigationBar(index)
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}
