package com.example.a24_shopping.data.repository

import com.example.a24_shopping.data.entity.product.ProductEntity

interface ProductRepository {

    suspend fun getProductList(): List<ProductEntity>

    suspend fun getLocalProductList(): List<ProductEntity>

    suspend fun insertProductItem(ProductItem: ProductEntity): Long

    suspend fun insertProductList(ProductList: List<ProductEntity>)

    suspend fun updateProductItem(itemId: Long): ProductEntity?

    suspend fun deleteAll()

    suspend fun deleteProductItem(id: Long)
}