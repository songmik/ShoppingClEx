package com.example.a24_shopping.domain.product

import com.example.a24_shopping.data.entity.product.ProductEntity
import com.example.a24_shopping.data.repository.ProductRepository
import com.example.a24_shopping.domain.UseCase

internal class GetProductItemUseCase(
    private val productRepository: ProductRepository
):UseCase {
    suspend operator fun invoke(productId: Long): ProductEntity? {
        return productRepository.getProductItem(productId)
    }
}