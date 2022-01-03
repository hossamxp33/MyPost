package com.tarweej.mypost.presentation.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.RequestDoneFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.mainactivity.MainActivity
import javax.inject.Inject

class FinishRequestFragment @Inject constructor() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view:  RequestDoneFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.request_done_fragment, container, false
        )

        view.context = context as RequestActivity
        view.listener = ClickHandler()

       view.searchButton.setOnClickListener {
           ClickHandler().switchToActivity(requireContext(),MainActivity())
       }
        return view.root
    }



}