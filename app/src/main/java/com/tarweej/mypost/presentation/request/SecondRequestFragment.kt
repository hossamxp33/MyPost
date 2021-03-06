package com.tarweej.mypost.presentation.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.Request2FragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import javax.inject.Inject

class SecondRequestFragment @Inject constructor() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: Request2FragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.request_2_fragment, container, false
        )

        view.context = context as RequestActivity
        view.listener = ClickHandler()


        return view.root
    }



}