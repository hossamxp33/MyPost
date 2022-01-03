package com.tarweej.mypost.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.ProfileFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import javax.inject.Inject


class ProfileFragment @Inject constructor() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: ProfileFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.profile_fragment, container, false
        )




        return view.root
    }


    }