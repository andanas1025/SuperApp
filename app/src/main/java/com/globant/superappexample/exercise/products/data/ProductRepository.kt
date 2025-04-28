package com.globant.superappexample.exercise.products.data

import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun fetchProducts(): Flow<List<ProductDto>>
}

