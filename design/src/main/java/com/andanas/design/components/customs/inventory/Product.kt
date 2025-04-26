package com.andanas.design.components.customs.inventory

data class Product(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val code: String = "",
    val stock: Int = 0,
    val category: String = "",
    val location: String = "",
    val creationDate: Long = System.currentTimeMillis()
)
