package com.tarweej.mypost.presentation.settingsfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FragmentSettingsBinding
import com.tarweej.mypost.databinding.ProfileFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.presentation.auth.AuthenticationActivity


class SettingsFragment : Fragment() {

    lateinit var view: FragmentSettingsBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_settings, container, false
        )
        auth = FirebaseAuth.getInstance()
        view.logoutBtn.setOnClickListener {
            auth.signOut()
            val logoutIntent = Intent(requireContext(), AuthenticationActivity::class.java)
            logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(logoutIntent)
        }

        return view.root
    }


}