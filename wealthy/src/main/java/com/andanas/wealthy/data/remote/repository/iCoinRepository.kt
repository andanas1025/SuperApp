package com.andanas.wealthy.data.remote.repository

import com.andanas.wealthy.data.remote.dto.CoinDto
import com.andanas.wealthy.domain.model.Coin
import com.andanas.wealthy.domain.model.CoinDetail
import com.globant.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface iCoinRepository {

    suspend fun getCoins(): Flow<Resource<List<Coin>>>

    suspend fun getCoinDetails(coinId: String): Flow<Resource<CoinDetail>>
}