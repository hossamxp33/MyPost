package com.tarweej.mypost.presentation.request

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tarweej.mypost.R

class RequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_activity)

        if (savedInstanceState == null) {

        }

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(0, 0, 0, 0)
            .replace(R.id.requestFrame, FirstRequestFragment())
            .commit()



    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        ClickHandler().switchToActivity(this@RequestActivity , MainActivity())
//
//    }

    }