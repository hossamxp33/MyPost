package com.tarweej.mypost.presentation.settings_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FragmentSettingsBinding
import com.tarweej.mypost.helper.PreferenceHelper
import com.tarweej.mypost.helper.setCircleImageResource
import com.tarweej.mypost.helper.setImageResource
import com.tarweej.mypost.presentation.auth.AuthenticationActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject


class SettingsActivity : AppCompatActivity(), HasAndroidInjector {


    private lateinit var mGoogleSignInClient: GoogleSignInClient

    @Inject
    lateinit var Pref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_settings)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        setImageResource(appCompatImageView4, Pref.photo)

        logout_btn.setOnClickListener {
            mGoogleSignInClient.signOut()
            val logoutIntent = Intent(this, AuthenticationActivity::class.java)
            logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(logoutIntent)
        }


    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}