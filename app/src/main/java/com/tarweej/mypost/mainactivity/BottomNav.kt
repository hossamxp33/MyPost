package com.tarweej.mypost.mainactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment

import com.tarweej.mypost.R
import com.tarweej.mypost.presentation.homefragment.HomeFragment
import com.tarweej.mypost.presentation.myorders.MyOrdersFragment
import com.tarweej.mypost.presentation.profile.ProfileFragment

import com.tarweej.mypost.presentation.request.FirstRequestFragment
import kotlinx.android.synthetic.main.bottom_nav_content.*
import java.util.*


class BottomNav {

    private val mMenuItemSelected = 0
    var integerDeque: Deque<Int> = LinkedList()
    var flag: Boolean = true
     var fragment: Fragment = HomeFragment()
    lateinit var activity: AppCompatActivity


     fun getFragment(context: Context,itemId: Int): Fragment {

        with( (context as MainActivity).bottom_nav_bar){
        when (itemId) {
            R.id.home -> {
               menu.getItem(0).isChecked = true
                fragment = HomeFragment()
            }
            R.id.myOrder -> {
               menu.getItem(1).isChecked = true
                fragment = MyOrdersFragment()
            }
            R.id.main -> {
                menu.getItem(2).isChecked = true
                fragment = ProfileFragment()
            }
            R.id.Request -> {
               menu.getItem(3).isChecked = true
                fragment = FirstRequestFragment()
            }

            R.id.profile -> {
               menu.getItem(4).isChecked = true
                fragment = ProfileFragment()
            }
        }
        }

        return fragment
    }


}