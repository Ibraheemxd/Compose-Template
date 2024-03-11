package com.keeper.foundation.ui.explore

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

data class ExploreScreen(
    val message: String
) :  Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        ExploreScreenView(message, navigator::pop)
    }
}
