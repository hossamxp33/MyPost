package com.tarweej.mypost.presentation.famousprofilefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FamousProfileAdapterBinding
import com.tarweej.mypost.databinding.FamousProfileFragmentBinding
import com.tarweej.mypost.helper.BaseApplication

class FamousProfileFragment : BottomSheetDialogFragment() {
    lateinit var view: FamousProfileFragmentBinding
    companion object { const val TAG = "BottomSheetDialogFragment" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.famous_profile_fragment, container, false
        )





        return view.root
    }

}