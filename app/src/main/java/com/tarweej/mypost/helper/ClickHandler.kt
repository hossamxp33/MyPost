package com.tarweej.mypost.helper

import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.entites.famousinfo.FamousInfo
import com.tarweej.mypost.mainactivity.MainActivity
import com.tarweej.mypost.presentation.famousprofilefragment.FamousProfileFragment
import com.tarweej.mypost.presentation.notification.NotificationFragment
import com.tarweej.mypost.presentation.famous_fragment.FamousFragment
import com.tarweej.mypost.presentation.request.*

class ClickHandler {

fun famousProfileFragment (context: Context){
    val frag = FamousProfileFragment()
    frag.apply {
        show((context as MainActivity).supportFragmentManager, FamousProfileFragment.TAG)
    }
}
    fun switchToSecondRequestFragment(context: Context) {
        switchToRequestFragment(context as RequestActivity, SecondRequestFragment())
    }
    fun switchToFirstRequestFragment(context: Context) {
        switchToRequestFragment(context as RequestActivity, FirstRequestFragment())
    }

    fun switchToThirdRequestFragment(context: Context) {
        switchToRequestFragment(context, ThirdRequestFragment())
    }

    fun switchToFinishRequestFragment(context: Context) {
        switchToRequestFragment(context, FinishRequestFragment())
    }

    fun switchSearchFragment(context: Context) {
        switchFragment(context, FamousFragment())
    }

    fun switchNotificationFragment(context: Context) {
        switchFragment(context, NotificationFragment())
    }




    fun switchFragment(context: Context, fragment: Fragment) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .setCustomAnimations(0, 0, 0, 0)
            .replace(R.id.main_frame, fragment).addToBackStack(null).commit()
    }

    fun switchToRequestFragment(context: Context, fragment: Fragment) {
        (context as RequestActivity).supportFragmentManager.beginTransaction()
            .setCustomAnimations(0, 0, 0, 0)
            .replace(R.id.requestFrame, fragment).addToBackStack(null).commit()
    }


    fun switchToActivity(context: Context, activity: AppCompatActivity) {

        val i = Intent(context, activity::class.java)
        (context).startActivity(i);

    }

    fun openItemDetailsFragment(context: Context, famousId: Int) {
            val frag = FamousProfileFragment()
            var bundle = Bundle()
      //      bundle.putSerializable("Item", Item.famous_id)
            bundle.putInt("famousId", famousId)
            frag.arguments = bundle

            frag.apply {
                show((context as RequestActivity).supportFragmentManager, FamousProfileFragment.TAG)
            }
    }

}
