package com.andanas.wealthy.presentation.screens.wealthyHome

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
import com.andanas.design.components.AppToolbar
import com.andanas.design.ui.theme.whiteColor
import com.andanas.wealthy.R

@Composable
fun WealthyScreenApp(
    primaryButtonClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            AppToolbar(
                stringResource(R.string.wealthy_title),
                isBackButtonVisible = true,
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

        }
    }
}

@Preview
@Composable
fun WealthyScreenAppPreview() {
    WealthyScreenApp()
}