package com.example.a24_shopping.presentation.list

import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isGone
import com.example.a24_shopping.databinding.FragmentProductListBinding
import com.example.a24_shopping.presentation.BaseFragment
import com.example.a24_shopping.presentation.adapter.ProductListAdapter
import com.example.a24_shopping.presentation.detail.ProductDetailActivity
import com.example.a24_shopping.presentation.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

internal class ProductListFragment:BaseFragment<ProductListViewModel, FragmentProductListBinding>() {

    companion object{
        const val TAG = "ProductListFragment"
    }

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

    private val adapter = ProductListAdapter()

    override val viewModel by viewModel<ProductListViewModel>()

    private val startProductDetailForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == ProductDetailActivity.PRODUCT_ORDERED_RESULT_CODE) {
                (requireActivity() as MainActivity).viewModel.refreshOrderList()
            }
        }

    private fun initViews(binding: FragmentProductListBinding) = with(binding) {
        recyclerView.adapter = adapter

        refreshLayout.setOnRefreshListener {
            viewModel.fetchData()
        }
    }

    override fun observeData() {
        viewModel.productListStateLiveData.observe(this) {
            when(it) {
                is ProductListState.UnInitialized -> {
                    initViews(binding)
                }
                is ProductListState.Loading -> {
                    handleLoadingState()
                }
                is ProductListState.Success -> {
                    handleSuccessState(it)
                }
                is ProductListState.Error -> {
                    handleErrorState()
                }
            }
        }
    }

    private fun handleLoadingState() = with(binding) {
        refreshLayout.isRefreshing = true
    }

    private fun handleSuccessState(state: ProductListState.Success) = with(binding) {
        refreshLayout.isEnabled = state.productList.isNotEmpty()
        refreshLayout.isRefreshing = false

        if (state.productList.isEmpty()){
            emptyResultTextView.isGone = false
            recyclerView.isGone = true
        } else {
            emptyResultTextView.isGone = true
            recyclerView.isGone = false
            adapter.setProductList(state.productList) {
                startProductDetailForResult.launch(
                    ProductDetailActivity.newIntent(requireContext(), it.id)
                )
            }
        }
    }

    private fun handleErrorState() {
        Toast.makeText(requireContext(), "????????? ??????????????????.", Toast.LENGTH_SHORT).show()
    }
}