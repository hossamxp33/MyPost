package com.tarweej.mypost.presentation.famous.social

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FamousSocialMediaFragmentBinding
import com.tarweej.mypost.databinding.NotificationFragmentBinding
import com.tarweej.mypost.databinding.ProfileFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.presentation.famous.auth.FamousAuthenticationActivity
import javax.inject.Inject


class FamousSocialFragment @Inject constructor() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: FamousSocialMediaFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.famous_social_media_fragment, container, false
        )

        view.listener = ClickHandler()
        view.context = context as FamousAuthenticationActivity





        return view.root
    }


    }