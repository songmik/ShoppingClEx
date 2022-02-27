package com.example.a24_shopping.data.response

data class ProductsResponse(
    val items: List<ProductResponse>,
    val count: Int
)