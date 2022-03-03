package com.example.a24_shopping.domain.product

import com.example.a24_shopping.data.repository.ProductRepository
import com.example.a24_shopping.domain.UseCase

internal class DeleteOrderedProductListUseCase(
    private val productRepository: ProductRepository
): UseCase {
    suspend operator fun invoke() {
        return productRepository.deleteAll()
    }
}