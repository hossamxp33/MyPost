package com.tarweej.mypost.presentation.auth.sign_in_fragment

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
import com.tarweej.mypost.entites.User
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.helper.PreferenceHelper
import com.tarweej.mypost.mainactivity.MainActivity
import com.tarweej.mypost.presentation.auth.AuthenticationActivity
import com.tarweej.mypost.presentation.auth.sign_in_fragment.viewmodel.AuthViewModel
import javax.inject.Inject


class SingInFragment @Inject constructor() : Fragment() {
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


    lateinit var view: SignInFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.sign_in_fragment, container, false
        )
        auth = FirebaseAuth.getInstance()


        TopicTitle()
        view.signInButton.setOnClickListener {
            loginRequest()
        }


        viewModel.authLD?.observe(requireActivity() , Observer {
            if (it.message != null){
                Toast.makeText(context , it.message, Toast.LENGTH_SHORT).show()
            }else {
                Pref.userName= (it.data?.username)
                Pref.token= (it.data?.token)
                Pref.UserId  =  it.data?.userid!!
                Toast.makeText(context , "تم تسجيل الدخول", Toast.LENGTH_SHORT).show()
                 ClickHandler().switchToActivity(context as AuthenticationActivity , MainActivity())
            }

        })
        viewModel.errorMessage.observe(requireActivity(),{
            Toast.makeText(context ,"Wrong name or password", Toast.LENGTH_SHORT).show()
        })


        return view.root
    }



    fun TopicTitle() {
        //// top topic title
        val Enjoy = getString(R.string.new_here)
        val first = "<font color='#000000'>$Enjoy</font>"
        val next = getString(R.string.create_acc)
        view.createAccText.text = Html.fromHtml(first + next)
    }
    fun loginRequest() {

        val username = view.username.text.toString()
        val password = view.password.text.toString()

        viewModel.login(username,password)
    }



}