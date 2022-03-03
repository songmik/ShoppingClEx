package com.example.a24_shopping.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.a24_shopping.domain.product.GetOrderedProductListUseCase
import com.example.a24_shopping.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProductListViewModel(
    val getProductListUseCase: GetOrderedProductListUseCase
):BaseViewModel() {

    private var _productListStateLiveData = MutableLiveData<ProductListState>(ProductListState.UnInitialized)
    val productListStateLiveData: LiveData<ProductListState> = _productListStateLiveData
    override fun fetchData(): Job = viewModelScope.launch {
        _productListStateLiveData.postValue(ProductListState.Loading)
        _productListStateLiveData.postValue(ProductListState.Success(getProductListUseCase()))
    }
}