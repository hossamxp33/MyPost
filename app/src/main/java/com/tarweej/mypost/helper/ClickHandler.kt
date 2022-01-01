package com.tarweej.mypost.helper

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.mainactivity.MainActivity
import com.tarweej.mypost.presentation.request.RequestActivity
import com.tarweej.mypost.presentation.request.SecondRequestFragment
import com.tarweej.mypost.presentation.request.ThirdRequestFragment
import kotlinx.android.synthetic.main.bottom_nav_content.*

class ClickHandler {

    fun switchToSecondRequestFragment(context:Context){
         switchFragment(context,SecondRequestFragment())
    }
    fun switchToThirdRequestFragment(context:Context){
        switchFragment(context,ThirdRequestFragment())
    }

    fun switchFragment(context:Context,fragment :Fragment){

        (context as MainActivity).supportFragmentManager.beginTransaction()
            .setCustomAnimations(0, 0, 0, 0)
            .replace(R.id.main_frame, fragment).addToBackStack(null).commit()
    }

    fun bottomNavItemSelected(context: Context,id: Int?) {

        with((context as MainActivity).bottom_nav_bar){

        }
    }


    fun switchToActivity(context: Context,) {
        context as MainActivity
        val i = Intent(context, RequestActivity::class.java)
        (context).startActivity(i);

    }
    }
