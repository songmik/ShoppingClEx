package com.example.a24_shopping.presentation.profile

import com.example.a24_shopping.databinding.FragmentProductListBinding
import com.example.a24_shopping.presentation.BaseFragment
import org.koin.android.ext.android.inject

internal class ProfileFragment: BaseFragment<ProfileViewModel, FragmentProductListBinding>() {

    override val viewModel by inject<ProfileViewModel>()

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

    override fun observeData() {
        TODO("Not yet implemented")
    }
}