package com.andanas.wealthy.data.repository

import com.andanas.wealthy.data.remote.CoinApi
import com.andanas.wealthy.data.remote.dto.toCoin
import com.andanas.wealthy.domain.model.Coin
import com.andanas.wealthy.domain.model.CoinDetail
import com.andanas.wealthy.domain.repository.ICoinRepository
import com.globant.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : ICoinRepository {

    override suspend fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = api.getCoins()
            emit(Resource.Success(coins.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }

    override suspend fun getCoinDetails(coinId: String): Flow<Resource<CoinDetail>> {
        TODO("Not yet implemented")
    }
}