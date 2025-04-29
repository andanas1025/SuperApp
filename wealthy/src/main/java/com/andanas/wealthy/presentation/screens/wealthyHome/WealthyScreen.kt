package com.andanas.wealthy.presentation.screens.wealthyHome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.andanas.design.components.AppToolbar
import com.andanas.design.components.ErrorComponent
import com.andanas.design.components.Loading
import com.andanas.design.ui.theme.whiteColor
import com.andanas.wealthy.R
import com.andanas.wealthy.domain.model.Coin
import com.andanas.wealthy.presentation.components.CoinListItem
import com.andanas.wealthy.presentation.screens.wealthyHome.WealthyScreenState.*
import com.andanas.wealthy.presentation.screens.wealthyHome.WealthyScreenState.Loading as Loading1

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
        val state by wealthyViewModel.state.collectAsStateWithLifecycle()
        when (state) {
            is Loading1 -> LoadingScreen()
            is Error -> {
                ErrorScreen((state as Error).message)
            }

            is Success -> {
                SuccessScreen((state as Success).coins, innerPadding)
            }
        }
    }
}

@Composable
fun SuccessScreen(coins: List<Coin>, innerPadding: PaddingValues) {
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
            items(coins) { coin ->
                CoinListItem(coin)
            }
        }
    }
}

@Composable
fun ErrorScreen(message: String?) {
    message?.let {
        ErrorComponent(errorButtonText = message)
    }
}

@Composable
fun LoadingScreen() {
    Loading()
}

@Preview
@Composable
fun WealthyScreenAppPreview() {
    WealthyScreenApp()
}