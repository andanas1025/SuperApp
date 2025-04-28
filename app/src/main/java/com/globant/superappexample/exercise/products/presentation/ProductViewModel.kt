package com.globant.superappexample.exercise.products.presentation

import com.globant.superappexample.exercise.products.data.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) {

}