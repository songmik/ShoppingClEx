package com.example.a24_shopping.data.repository

import com.example.a24_shopping.data.db.dao.ProductDao
import com.example.a24_shopping.data.entity.product.ProductEntity
import com.example.a24_shopping.data.network.ProductApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultProductRepository(
    private val productAPi:ProductApiService,
    private val productDao: ProductDao,
    private val ioDispatcher: CoroutineDispatcher
): ProductRepository {
    override suspend fun getProductList(): List<ProductEntity> = withContext(ioDispatcher) {
        val response = productAPi.getProducts()
        return@withContext if (response.isSuccessful){
            response.body()?.items?.map { it.toEntity() }?: listOf()
        } else {
            listOf()
        }
    }

    override suspend fun getLocalProductList(): List<ProductEntity> = withContext(ioDispatcher) {
        productDao.getAll()
    }

    override suspend fun insertProductItem(ProductItem: ProductEntity): Long = withContext(ioDispatcher) {
        productDao.insert(ProductItem)
    }

    override suspend fun insertProductList(ProductList: List<ProductEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProductItem(itemId: Long): ProductEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun getProductItem(itemId: Long): ProductEntity? = withContext(ioDispatcher) {
        val response = productAPi.getProduct(itemId)
        return@withContext if (response.isSuccessful){
            response.body()?.toEntity()
        } else {
            null
        }
    }

    override suspend fun deleteAll() = withContext(ioDispatcher) {
        productDao.deleteAll()
    }

    override suspend fun deleteProductItem(id: Long) {
        TODO("Not yet implemented")
    }
}