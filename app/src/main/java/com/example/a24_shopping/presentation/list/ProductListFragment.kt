package com.example.a24_shopping.presentation.list

import android.app.Instrumentation
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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

    }

    private fun handleSuccessState(state: ProductListState.Success) = with(binding) {

    }

    private fun handleErrorState() {
        Toast.makeText(requireContext(), "에러가 발생했습니다.", Toast.LENGTH_SHORT).show()
    }
}