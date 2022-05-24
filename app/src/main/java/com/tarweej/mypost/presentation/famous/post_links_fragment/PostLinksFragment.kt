package com.tarweej.mypost.presentation.famous.post_links_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FamousSocialMediaFragmentBinding
import com.tarweej.mypost.databinding.NotificationFragmentBinding
import com.tarweej.mypost.databinding.PostLinksFragmentBinding
import com.tarweej.mypost.databinding.ProfileFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import javax.inject.Inject


class PostLinksFragment @Inject constructor() : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: PostLinksFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.post_links_fragment, container, false
        )



        view.linkFacebook.setOnClickListener {
            view.facebookBox.isVisible = true
        }

        view.dismiss.setOnClickListener {
            view.facebookBox.isVisible = false

        }

        view.linkTwitter.setOnClickListener {
            view.twitterBox.isVisible = true
        }

        view.twitterDismiss.setOnClickListener {
            view.twitterBox.isVisible = false

        }
        view.linkInsta.setOnClickListener {
            view.instaBox.isVisible = true
        }

        view.instaDismiss.setOnClickListener {
            view.instaBox.isVisible = false

        }

        view.linkSnap.setOnClickListener {
            view.snapBox.isVisible = true
        }

        view.snapDismiss.setOnClickListener {
            view.snapBox.isVisible = false

        }


        return view.root
    }


}