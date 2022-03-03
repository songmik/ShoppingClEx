package com.example.a24_shopping.presentation.detail

import android.content.Context
import android.content.Intent
import com.example.a24_shopping.extensions.toast
import com.example.a24_shopping.presentation.BaseActivity
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.core.parameter.parametersOf

internal class ProductDetailActivity : BaseActivity<ProductDetailViewModel, ActivityProductDetailBinding>() {

    companion object {
        const val PRODUCT_ID_KEY ="PRODUCT_ID_KEY"
        const val PRODUCT_ORDERED_RESULT_CODE =99

        fun newIntent(context: Context, productId: Long) =
            Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID_KEY, productId)
            }
    }

    override val viewModel by viewModel<ProductDetailViewModel>{
        parametersOf(
            intent.getLongExtra(PRODUCT_ID_KEY, -1)
        )
    }

    override fun getViewBinding(): ActivityProductDetailBinding =
        ActivityProductDetailBinding.inflate(layoutInflater)

    override fun observeData() = viewModel.productDetailState.observe(this) {
        when (it) {
            is ProductDetailState.UnIn
        }
    }

    private fun initViews() = with(binding) {
        setSupportActionBar()

    }

    private fun handleLoading() = with(binding){

    }

    private fun handleSuccess(state: ProductDetailState.Success) = with(binding) {

    }

    private fun handleError() {
        toast("제품 정보를 불러올 수 없습니다.")
    }

    private fun handlerOrder() {
        setResult(PRODUCT_ORDERED_RESULT_CODE)
        toast("성공적으로 주문이 완료되었습니다.")
        finish()
    }
}