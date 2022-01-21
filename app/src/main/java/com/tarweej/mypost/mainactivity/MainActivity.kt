package com.tarweej.mypost.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.tarweej.mypost.R
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.presentation.homefragment.HomeFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.bottom_nav_content.*
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.*
import javax.inject.Inject


import com.tarweej.mypost.presentation.request.RequestActivity
import com.tarweej.mypost.presentation.famous_fragment.FamousFragment
import kotlinx.android.synthetic.main.top_bar.*
import kotlinx.android.synthetic.main.top_bar.view.*


class MainActivity : AppCompatActivity(), HasAndroidInjector {

    var doubleBackToExitPressedOnce :Boolean = false

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    lateinit var fragment: Fragment

    var integerDeque: Deque<Int> = LinkedList()

    var flag: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        supportFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(0, 0, 0, 0)
                .replace(R.id.main_frame, HomeFragment())
                .commit()
                 bottom_nav_bar.selectedItemId = R.id.home
        }

        //      BottomNav().bottomMenu(this)


        bottom_nav_bar.setOnNavigationItemSelectedListener {
//            supportFragmentManager.addOnBackStackChangedListener {
//                if (supportFragmentManager.backStackEntryCount == 0) {
//                    if (fragmentManager.backStackEntryCount <= 0) {
//                        //check your position based on selected fragment and set it accordingly.
//                        bottom_nav_bar.menu.getItem(0).isChecked = true
//                    }                }
//                // Other magic
//            }


            val id = it.itemId
            if (integerDeque.contains(id)) {

                if (id == R.id.home) {
                    if (integerDeque.size != 0) {
                        if (flag) {
                            integerDeque.addFirst(R.id.home)
                            flag = false
                        }

                    }
                }
                integerDeque.remove(id)
            }
            integerDeque.push(id)
            ClickHandler().switchFragment(this, BottomNav().getFragment(this, it.itemId))
            with(bottom_nav_bar) {
                when (it.itemId) {
                    R.id.home -> {
                        menu.getItem(0).isChecked = true
                    }

                    R.id.myOrder -> {
                        menu.getItem(1).isChecked = true
                    }
                    R.id.main -> {
                        menu.getItem(2).isChecked = true
                    }
                    R.id.Request -> {
                        ClickHandler().switchToActivity(this@MainActivity,RequestActivity())
                    }

                    R.id.profile -> {
                        menu.getItem(4).isChecked = true
                    }
                    else ->
                {
                    fragment = HomeFragment()
                    bottom_nav_bar.selectedItemId = R.id.home
                }
                }
            }
            true
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        integerDeque.poll()
        if (!integerDeque.isNullOrEmpty()) {
            ClickHandler().switchFragment(
                this,
                BottomNav().getFragment(this, integerDeque.peek()!!)
            )

        }
        else if (doubleBackToExitPressedOnce)
            finish()

        else if (fragmentManager.backStackEntryCount == 0){
            bottom_nav_bar.selectedItemId = R.id.home
            doubleBackToExitPressedOnce  = true
        }



//       Handler(Looper.getMainLooper()).postDelayed(Runnable {  }, 2000)

    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }


}