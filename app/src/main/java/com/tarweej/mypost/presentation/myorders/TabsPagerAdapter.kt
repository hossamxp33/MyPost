package com.tarweej.mypost.presentation.myorders

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
           //     val bundle = Bundle()
             //   bundle.putString("fragmentName", "Music Fragment")
                val allOrdersFragment = AllOrdersFragment()
          //      login.arguments = bundle
                return allOrdersFragment
            }
            1 -> {
                return   AcceptedOrdersFragment()
            }

            else -> return AllOrdersFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}