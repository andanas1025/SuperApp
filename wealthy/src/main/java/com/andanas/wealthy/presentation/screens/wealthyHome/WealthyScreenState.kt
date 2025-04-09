package com.andanas.wealthy.presentation.screens.wealthyHome

import com.andanas.wealthy.domain.model.Coin

data class WealthyScreenState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String? = null
)