package com.example.a24_shopping.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.a24_shopping.data.entity.product.ProductEntity
import com.example.a24_shopping.domain.product.GetProductItemUseCase
import com.example.a24_shopping.domain.product.OrderProductItemUseCase
import com.example.a24_shopping.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProductDetailViewModel (
    private val productId: Long,
    private val getProductItemUseCase: GetProductItemUseCase,
    private val orderedProductItemUseCase: OrderProductItemUseCase
    ): BaseViewModel(){

    private var _productDetailState = MutableLiveData<ProductDetailState>(ProductDetailState.UnInitialized)
    val productDetailState: LiveData<ProductDetailState> = _productDetailState

    private lateinit var productEntity: ProductEntity

    override fun fetchData(): Job = viewModelScope.launch {
        setState(ProductDetailState.Loading)
        getProductItemUseCase(productId)?.let { product ->
            productEntity = product
            setState(
                ProductDetailState.Success(product)
            )
        } ?: kotlin.run {
            setState(ProductDetailState.Error)
        }
    }

    fun orderProduct() = viewModelScope.launch {
        val productId = orderedProductItemUseCase(productEntity)
        if (productEntity.id == productId){
            setState(ProductDetailState.Order)
        }
    }

    private fun setState(state: ProductDetailState){
        _productDetailState.postValue(state)
    }


}