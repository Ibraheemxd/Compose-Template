package com.keeper.foundation.ui.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keeper.foundation.designsystem.icon.KeeperIcons

@Composable
fun ExploreScreenView(
    message: String,
    onNavigateUp: () -> Unit
) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Explore screen",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Message: $message",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Button(onClick = onNavigateUp) {
                Icon(imageVector = KeeperIcons.Navigate, contentDescription = "navigateUp")
                Text(text = "Back")
            }
        }
    }

}