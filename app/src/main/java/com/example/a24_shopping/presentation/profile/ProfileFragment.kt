package com.example.a24_shopping.presentation.profile

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a24_shopping.R
import com.example.a24_shopping.databinding.FragmentProductListBinding
import com.example.a24_shopping.databinding.FragmentProfileBinding
import com.example.a24_shopping.presentation.BaseFragment
import com.example.a24_shopping.presentation.adapter.ProductListAdapter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.viewmodel.ext.android.viewModel

internal class ProfileFragment: BaseFragment<ProfileViewModel, FragmentProductListBinding>() {

    companion object{
        const val TAG = "ProfileFragment"
    }

    override val viewModel by viewModel<ProfileViewModel>()

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)


    private val gso: GoogleSignInOptions by lazy {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.defalt_web_client_id))
            .requestEmail()
            .build()
    }

    private val gsc by lazy { GoogleSignIn.getClient(requireActivity(), gso) }

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try{
              task.getResult(ApiException::class.java)?.let{ account ->
                  Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                  viewModel.saveToken(account.idToken ?: throw  Exception())
              } ?: throw Exception()
            } catch(e: Exception){
               e.printStackTrace()
                handleErrorState()
             }
        }

    }

    private val adapter = ProductListAdapter()

    private fun initViews(binding: FragmentProfileBinding) = with(binding){

    }

    private fun signInGoogle() {
        val signInIntent: Intent = gsc.signInIntent
        launcher.launch(signInIntent)
    }

    private fun signOut() {
        firebaseAuth.signOut()
        viewModel.signOut()
    }

    override fun observeData() {
        viewModel.profileStateLiveData.observe(this){
            when(it){

            }
        }
    }

    private fun handleLoadingState() = with(binding) {

    }

    private fun handleLogin(state: ProfileState.Login){

    }

    private fun handleSuccessState(state: ProfileState.Success) = with(binding){

    }

    private fun handleRegisteredState(state: ProfileState.Success.Registered) = with(binding) {

    }

    private fun handleErrorState(){

    }

}