package com.example.a24_shopping.data.repository

import com.example.a24_shopping.data.entity.product.ProductEntity
import com.example.a24_shopping.data.network.ProductApiService
import kotlinx.coroutines.CoroutineDispatcher

class DefaultProductRepository(
    private val productAPi:ProductApiService,
    private val productDao:ProductDao,
    private val ioDispatcher: CoroutineDispatcher
): ProductRepository {
    override suspend fun getProductList(): List<ProductEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getLocalProductList(): List<ProductEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertProductItem(ProductItem: ProductEntity): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertProductList(ProductList: List<ProductEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProductItem(itemId: Long): ProductEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProductItem(id: Long) {
        TODO("Not yet implemented")
    }
}