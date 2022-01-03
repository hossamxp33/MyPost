package com.tarweej.mypost.presentation.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.RequestFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import javax.inject.Inject

class FirstRequestFragment @Inject constructor() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: RequestFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.request_fragment, container, false
        )

        val items = listOf("Material", "Design", "Components", "Android")

        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, items)

        view.context = context as RequestActivity

        view.listener = ClickHandler()

        view.filledExposedDropdown.setAdapter(adapter)


        view.categoryTypeText.setAdapter(adapter)

        return view.root

    }


}