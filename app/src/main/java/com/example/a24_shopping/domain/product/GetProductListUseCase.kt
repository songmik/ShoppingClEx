package com.example.a24_shopping.domain.product

import com.example.a24_shopping.data.entity.product.ProductEntity
import com.example.a24_shopping.data.repository.ProductRepository
import com.example.a24_shopping.domain.UseCase
import org.w3c.dom.ls.LSInput

internal class GetProductListUseCase(
    private val productRepository: ProductRepository
): UseCase{

    suspend operator fun invoke(): List<ProductEntity>{
        return productRepository.getProductList()
    }
}