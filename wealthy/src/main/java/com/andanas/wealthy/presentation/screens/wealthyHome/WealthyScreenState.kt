package com.andanas.wealthy.presentation.screens.wealthyHome

import com.andanas.wealthy.domain.model.Coin

sealed interface WealthyScreenState {
    data object Loading : WealthyScreenState
    data class Success(val coins: List<Coin>) : WealthyScreenState
    data class Error(val message: String?) : WealthyScreenState
}