package com.tarweej.mypost.presentation.famous.auth

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.NotificationFragmentBinding
import com.tarweej.mypost.databinding.ProfileFragmentBinding
import com.tarweej.mypost.databinding.SignInFragmentBinding
import com.tarweej.mypost.databinding.SignUpFragmentBinding
import com.tarweej.mypost.entites.User
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.helper.PreferenceHelper
import com.tarweej.mypost.mainactivity.MainActivity
import com.tarweej.mypost.presentation.auth.AuthenticationActivity
import com.tarweej.mypost.presentation.auth.sign_in_fragment.viewmodel.AuthViewModel
import javax.inject.Inject


class FamousSingUpFragment @Inject constructor() : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<AuthViewModel> { viewModelFactory }

    private lateinit var auth: FirebaseAuth
    @Inject

    lateinit var Pref: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }


    }


    lateinit var view: SignUpFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.sign_up_fragment, container, false
        )

         view.listener = ClickHandler()
         view.context = context as FamousAuthenticationActivity






        return view.root
    }







}