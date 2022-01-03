package com.tarweej.mypost.presentation.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.Request3FragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.presentation.homefragment.HomeFragment
import javax.inject.Inject

class ThirdRequestFragment @Inject constructor() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: Request3FragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.request_3_fragment, container, false
        )
        view.context = context as RequestActivity
        view.listener = ClickHandler()
       view.backBtn.setOnClickListener {
           ClickHandler().switchToRequestFragment(requireContext(),HomeFragment())
       }
        return view.root
    }



}