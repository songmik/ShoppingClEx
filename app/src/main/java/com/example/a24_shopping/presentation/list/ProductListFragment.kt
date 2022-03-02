package com.example.a24_shopping.presentation.list

import com.example.a24_shopping.databinding.FragmentProductListBinding
import com.example.a24_shopping.presentation.BaseFragment
import com.example.a24_shopping.presentation.profile.ProfileViewModel
import org.koin.android.ext.android.inject

internal class ProductListFragment:BaseFragment<ProductListViewModel, FragmentProductListBinding>() {

    companion object{
        const val TAG = "ProductListFragment"
    }

    override val viewModel by inject<ProductListViewModel>()

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

    override fun observeData() {
        TODO("Not yet implemented")
    }
}