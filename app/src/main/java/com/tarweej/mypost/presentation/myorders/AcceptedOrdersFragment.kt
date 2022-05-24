package com.tarweej.mypost.presentation.myorders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FragmentAcceptedOrdersBinding

import com.tarweej.mypost.helper.BaseApplication



class AcceptedOrdersFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: FragmentAcceptedOrdersBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_accepted_orders, container, false
        )




        return view.root
    }


}