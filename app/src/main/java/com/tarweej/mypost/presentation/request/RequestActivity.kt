package com.tarweej.mypost.presentation.request

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tarweej.mypost.R
import dagger.android.AndroidInjection

class RequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_my_orders)

    }
    }