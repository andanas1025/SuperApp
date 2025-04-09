package com.andanas.wealthy.domain.useCase

import com.andanas.wealthy.domain.model.Coin
import com.andanas.wealthy.domain.repository.ICoinRepository
import com.globant.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: ICoinRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Coin>>> {
        return coinRepository.getCoins()
    }
}