package com.star_zero.bottomnav.singleactivity.ui.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.star_zero.bottomnav.singleactivity.ui.NavigationBarHeight

@Composable
fun SettingScreen(
    navigateToAccount: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Setting")
                }
            )
        },
        // for NavigationBar
        modifier = Modifier.padding(bottom = NavigationBarHeight)
    ) { padding ->
        SettingContent(
            navigateToAccount = navigateToAccount,
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun SettingContent(
    navigateToAccount: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        ListItem(
            headlineContent = {
                Text(text = "Account")
            },
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .clickable { navigateToAccount() }
                .padding(16.dp)
        )

        Divider()

        ListItem(
            headlineContent = {
                Text(text = "Notification")
            },
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .clickable { /*TODO*/ }
                .padding(16.dp)
        )

        Divider()
    }
}
