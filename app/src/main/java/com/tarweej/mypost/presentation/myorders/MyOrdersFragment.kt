package com.tarweej.mypost.presentation.myorders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FragmentMyOrdersBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.mainactivity.MainActivity
import kotlinx.android.synthetic.main.home_fragment.view.*
import kotlinx.android.synthetic.main.top_bar.*


class MyOrdersFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: FragmentMyOrdersBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_my_orders, container, false
        )

        val tabLayout = view.tabLayout
         val tabsViewpager = view.tabsViewpager

        tabLayout.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.gray_back_g))

  // Number Of Tabs
        val numberOfTabs = 2
        // Show all Tabs in screen
        tabLayout.tabMode = TabLayout.MODE_FIXED
        // Scroll to see all Tabs
        //tab_layout.tabMode = TabLayout.MODE_SCROLLABLE
        // Set divider
        tabLayout.isInlineLabel = true

        // Set the ViewPager Adapter
        val adapter =
            TabsPagerAdapter(fragmentManager!!, lifecycle, numberOfTabs)
        tabsViewpager.adapter = adapter
        // Enable Swipe
        tabsViewpager.isUserInputEnabled = true
        // Link the TabLayout and the ViewPager2 together and Set Text & Icons
        TabLayoutMediator(tabLayout, tabsViewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = this.getText(R.string.myorder)
                  
                  //  tab.setIcon(R.drawable.home_ic)


                }
                1 -> {
                     tab.text = this.getText(R.string.accepted)
              //       tab.setIcon(R.drawable.ringring_bg)
                }
            }

        }.attach()

        return view.root
    }


}