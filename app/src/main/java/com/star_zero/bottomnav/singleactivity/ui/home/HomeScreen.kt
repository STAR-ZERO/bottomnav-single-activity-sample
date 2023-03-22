package com.star_zero.bottomnav.singleactivity.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.star_zero.bottomnav.singleactivity.ui.NavigationBarHeight

@Composable
fun HomeScreen(
    navigateToDetail: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Home")
            })
        },
        // for NavigationBar
        modifier = Modifier.padding(bottom = NavigationBarHeight)
    ) { padding ->
        HomeContent(
            navigateToDetail = navigateToDetail, modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun HomeContent(
    navigateToDetail: () -> Unit, modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(30) { index ->
            ListItem(
                headlineContent = {
                    Text(text = "Item ${index + 1}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigateToDetail()
                    }
            )
        }
    }
}
