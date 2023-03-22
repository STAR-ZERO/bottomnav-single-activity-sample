package com.star_zero.bottomnav.singleactivity.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit
) {
    Scaffold { padding ->
        LoginContent(
            navigateToHome = navigateToHome,
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun LoginContent(
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        Button(onClick = navigateToHome) {
            Text(text = "Login")
        }
    }
}
