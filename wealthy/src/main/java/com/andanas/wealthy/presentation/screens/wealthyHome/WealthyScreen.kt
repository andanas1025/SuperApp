package com.andanas.wealthy.presentation.screens.wealthyHome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.andanas.design.components.AppToolbar
import com.andanas.design.ui.theme.whiteColor
import com.andanas.wealthy.R
import com.andanas.wealthy.presentation.components.CoinListItem

@Composable
fun WealthyScreenApp(
    primaryButtonClicked: () -> Unit = {},
    wealthyViewModel: WealthyScreenViewModel = hiltViewModel()
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
        val state = wealthyViewModel.state.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopStart)
                .background(whiteColor)
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.coins) { coin ->
                    CoinListItem(coin)
                }
            }
        }
    }
}

@Preview
@Composable
fun WealthyScreenAppPreview() {
    WealthyScreenApp()
}