package com.tarweej.mypost.presentation.loginas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tarweej.mypost.R

import com.tarweej.mypost.helper.PreferenceHelper
import com.tarweej.mypost.mainactivity.MainActivity
import com.tarweej.mypost.presentation.auth.AuthenticationActivity
import com.tarweej.mypost.presentation.famous.auth.FamousAuthenticationActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.login_as_fragment.*
import javax.inject.Inject


class LoginAsActivity: AppCompatActivity(), HasAndroidInjector {


    @Inject
    lateinit var Pref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_as_fragment)

        loginAsMerchant .setOnClickListener {

            val mainIntent = Intent(this, AuthenticationActivity::class.java)

            startActivity(mainIntent)
        }

        loginAsFamous.setOnClickListener {

            val mainIntent = Intent(this, FamousAuthenticationActivity::class.java)
            startActivity(mainIntent)

        }

    }
    override fun onResume() {
        super.onResume()

    }
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}














