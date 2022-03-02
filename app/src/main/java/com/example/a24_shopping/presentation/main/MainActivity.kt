package com.example.a24_shopping.presentation.main

import android.os.Bundle
import android.view.MenuItem
import com.example.a24_shopping.R
import com.example.a24_shopping.databinding.ActivityMainBinding
import com.example.a24_shopping.presentation.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import org.koin.android.ext.android.inject

internal class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(), BottomNavigationView.OnNavigationItemSelectedListener {

    override val viewModel: MainViewModel by inject<MainViewModel>()

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()

    }

    private fun initViews() = with(binding) {
        bottomNav.setOnNavigationItemSelectedListener(this@MainActivity)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    override fun observeData() {
        TODO("Not yet implemented")
    }
}