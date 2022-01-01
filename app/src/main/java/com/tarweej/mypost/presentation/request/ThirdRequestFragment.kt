package com.tarweej.mypost.presentation.request

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.ProfileFragmentBinding
import com.tarweej.mypost.databinding.Request2FragmentBinding
import com.tarweej.mypost.databinding.Request3FragmentBinding
import com.tarweej.mypost.databinding.RequestFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.mainactivity.MainActivity
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
       view.backBtn.setOnClickListener {
           (  context as MainActivity ).onBackPressed()
       }
        return view.root
    }



}