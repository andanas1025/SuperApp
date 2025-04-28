package com.globant.superappexample.exercise.products.presentation

data class ProductUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
)