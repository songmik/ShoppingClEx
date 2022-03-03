package com.example.a24_shopping.presentation.profile

import com.example.a24_shopping.R
import com.example.a24_shopping.databinding.FragmentProductListBinding
import com.example.a24_shopping.presentation.BaseFragment
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.viewmodel.ext.android.viewModel

internal class ProfileFragment: BaseFragment<ProfileViewModel, FragmentProductListBinding>() {

    companion object{
        const val TAG = "ProfileFragment"
    }

    override val viewModel by viewModel<ProfileViewModel>()

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

    override fun observeData() {
        TODO("Not yet implemented")
    }

    private val gso: GoogleSignInOptions by lazy {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.defalt_web_client_id))
            .requestEmail()
            .build()
    }

    private val gsc by lazy { GoogleSignIn.getClient(requireActivity(), gso) }

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }


}