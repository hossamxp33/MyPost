package com.tarweej.mypost.presentation.homefragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter


import com.tarweej.mypost.R
import com.tarweej.mypost.entites.home.Slider
import com.tarweej.mypost.helper.ShapeAppearanceModel
import com.tarweej.mypost.helper.setImageResource
import com.tarweej.mypost.mainactivity.MainActivity
import kotlinx.android.synthetic.main.viewpagerslide_home1.view.*
import javax.inject.Inject


class SliderAdapter @Inject constructor(val context: Context,val slidersData: List<Slider>) :
    PagerAdapter() {

    override fun getCount(): Int {
        return slidersData.size
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1 //To change body of created functions use File | Settings | File Templates.
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            (context as MainActivity).getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.viewpagerslide_home1, container, false)

        setImageResource(view.im_slider, slidersData[position].photo)

        container.addView(view)

        ShapeAppearanceModel(context, view.im_slider)


        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }


}
