package com.keeper.foundation.ui.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.keeper.foundation.ui.explore.ExploreScreen


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        HomeScreenNavigation(
            onExplore = { message ->
                navigator.push(ExploreScreen(message))
            }
        )
    }
}

@Composable
fun HomeScreenNavigation(
    onExplore: (message: String) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    HomeScreenView(
        message = viewModel.message,
        onExplore = { onExplore(viewModel.message) },
    )
}