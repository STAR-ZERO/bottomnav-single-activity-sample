package com.star_zero.bottomnav.singleactivity.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.star_zero.bottomnav.singleactivity.ui.detail.DetailRoute
import com.star_zero.bottomnav.singleactivity.ui.home.HomeGraph
import com.star_zero.bottomnav.singleactivity.ui.home.HomeRoute
import com.star_zero.bottomnav.singleactivity.ui.setting.SettingRoute

val NavigationBarRoutes = listOf(
    HomeRoute,
    DetailRoute,
    SettingRoute
)

enum class NavigationBarDestination(
    val icon: ImageVector,
    val route: String
) {
    HOME(
        icon = Icons.Default.Home,
        route = HomeGraph
    ),
    SETTING(
        icon = Icons.Default.Settings,
        route = SettingRoute
    )
}
