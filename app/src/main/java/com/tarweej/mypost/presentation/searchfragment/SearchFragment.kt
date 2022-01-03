package com.tarweej.mypost.presentation.searchfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.ProfileFragmentBinding
import com.tarweej.mypost.databinding.SearchFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import javax.inject.Inject


class SearchFragment @Inject constructor() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: SearchFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.search_fragment, container, false
        )




        return view.root
    }


    }