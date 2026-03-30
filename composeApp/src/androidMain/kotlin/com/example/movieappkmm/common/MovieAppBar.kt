package com.example.movieappkmm.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun MovieAppBar(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    currentScreen: Destination,
    onNavigateBack: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = modifier.padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = canNavigateBack) {
                IconButton(onClick = onNavigateBack) {
                    Text(
                        text = "←",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(modifier = modifier.width(24.dp))
            }

            Text(
                text = currentScreen.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(6.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}