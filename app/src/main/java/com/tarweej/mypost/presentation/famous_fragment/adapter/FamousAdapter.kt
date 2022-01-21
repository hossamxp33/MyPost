package com.tarweej.mypost.presentation.famous_fragment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FamousProfileAdapterBinding

import com.tarweej.mypost.entites.famousinfo.FamousInfo
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.mainactivity.MainActivity

import com.tarweej.mypost.presentation.request.RequestActivity


class FamousAdapter(var context: Context?) :

    ListAdapter<FamousInfo, ViewHolder>(DiffCallbackSpecialCustomer()) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding: FamousProfileAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.famous_profile_adapter, p0, false)



        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, currentList[position])

    }
}

private class DiffCallbackSpecialCustomer : DiffUtil.ItemCallback<FamousInfo>() {

    override fun areItemsTheSame(
        oldItem: FamousInfo, newItem: FamousInfo
    ) =
        oldItem.famous_id == newItem.famous_id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: FamousInfo, newItem: FamousInfo
    ) =
        oldItem == newItem
}


class ViewHolder(
    val binding: FamousProfileAdapterBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(context: Context?, data: FamousInfo) {

        binding.listener = ClickHandler()
        binding.data = data
        binding.context = context as RequestActivity?
    }


}
