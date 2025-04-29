package com.andanas.wealthy.presentation.screens.wealthyHome

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andanas.wealthy.domain.useCase.GetCoinsUseCase
import com.globant.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WealthyScreenViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<WealthyScreenState>(WealthyScreenState.Loading)
    val state: StateFlow<WealthyScreenState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCoins()
        }
    }

    private suspend fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = WealthyScreenState.Success(coins = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = WealthyScreenState.Error(message = result.message)
                }

                is Resource.Loading -> {
                    _state.value = WealthyScreenState.Loading
                }
            }
        }.launchIn(viewModelScope)
    }
}