package com.tarweej.mypost.presentation.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.HomeFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.mainactivity.MainActivity
import javax.inject.Inject


class HomeFragment @Inject constructor() : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: HomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment, container, false
        )

         view.include.context = context as MainActivity
         view.include.listener = ClickHandler()


        topProductsRecycleView()

        return view.root
    }

    fun topProductsRecycleView() {
        //  tripAdapter = FlightAdapter(requireContext())
        view.topProductsRecycleView.apply {
            layoutManager = GridLayoutManager(context, 2) // default orientation is vertical
            // adapter = tripAdapter;
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }
}