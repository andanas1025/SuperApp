package com.globant.superappexample.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.andanas.design.R.drawable.ic_inventory_app
import com.andanas.design.components.AppToolbar
import com.andanas.design.components.BannerComponent
import com.andanas.design.ui.theme.whiteColor
import com.globant.superappexample.R

@Composable
fun HomeScreen(
    primaryButtonClicked: () -> Unit = {},
    wealthBannerClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(R.string.home_screen_title),
                isBackButtonVisible = false,
                isNotificationVisible = true,
                primaryButtonClicked = primaryButtonClicked
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopStart)
                .background(whiteColor)
                .padding(innerPadding)
        ) {
            BannerComponent(
                title = "Wealthy Section",
                description = "Goes to Wealthy section to see more information",
                image = "https://images.unsplash.com/photo-1742403949587-42a767b9ea5b?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwxOHx8fGVufDB8fHx8fA%3D%3D",
                resourceValue = R.drawable.ic_launcher_foreground,
                bannerClicked = {
                    wealthBannerClicked()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}