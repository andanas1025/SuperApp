package com.andanas.wealthy.data.remote

import com.andanas.wealthy.data.remote.dto.CoinDetailDto
import com.andanas.wealthy.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoinDetail(@Path("coin_id") coinId: String) : CoinDetailDto
}