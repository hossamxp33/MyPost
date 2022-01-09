package com.tarweej.mypost.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.google.android.material.navigation.NavigationBarView
import com.tarweej.mypost.R
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.presentation.homefragment.HomeFragment
import com.tarweej.mypost.presentation.myorders.MyOrdersFragment
import com.tarweej.mypost.presentation.profile.ProfileFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.bottom_nav_content.*
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.*
import javax.inject.Inject


import com.tarweej.mypost.presentation.request.RequestActivity


class MainActivity : AppCompatActivity(), HasAndroidInjector {


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


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(0, 0, 0, 0)
                .replace(R.id.main_frame, HomeFragment())
                .addToBackStack(null)
                .commit()
            bottom_nav_bar.selectedItemId = R.id.home

        }

        //      BottomNav().bottomMenu(this)



        bottom_nav_bar.setOnNavigationItemSelectedListener {
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
                        ClickHandler().switchFragment(this@MainActivity, HomeFragment())
                    }
                    R.id.myOrder -> {
                        menu.getItem(1).isChecked = true
                        ClickHandler().switchFragment(this@MainActivity, MyOrdersFragment())
                    }
                    R.id.main -> {
                        menu.getItem(2).isChecked = true

                    }
                    R.id.Request -> {

                        ClickHandler().switchToActivity(this@MainActivity,RequestActivity())
                    }

                    R.id.profile -> {
                        menu.getItem(4).isChecked = true
                        fragment = ProfileFragment()
                    }
                    else ->
                {
                    menu.getItem(0).isChecked = true
                    ClickHandler().switchFragment(this@MainActivity, HomeFragment())
                }
                }


            }


            true

        }


    }


    override fun onBackPressed() {

        integerDeque.pop()
        if (!integerDeque.isNullOrEmpty()) {
            ClickHandler().switchFragment(
                this,
                BottomNav().getFragment(this, integerDeque.peek()!!)
            )

        } else

            super.onBackPressed()
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }


}