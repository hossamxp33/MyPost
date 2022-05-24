package com.tarweej.mypost.presentation.myorders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FragmentAllOrdersBinding
import com.tarweej.mypost.databinding.FragmentMyOrdersBinding
import com.tarweej.mypost.databinding.NotificationFragmentBinding
import com.tarweej.mypost.helper.BaseApplication



class AllOrdersFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: FragmentAllOrdersBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_all_orders, container, false
        )




        return view.root
    }


}