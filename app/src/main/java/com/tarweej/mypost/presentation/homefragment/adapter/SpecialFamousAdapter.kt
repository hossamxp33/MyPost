package com.tarweej.mypost.presentation.homefragment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.SpecialCustomerItemAdapterBinding
import com.tarweej.mypost.databinding.SpecialFamousItemAdapterBinding
import com.tarweej.mypost.databinding.TopProductItemAdapterBinding
import com.tarweej.mypost.entites.home.SpecialFamouse
import com.tarweej.mypost.mainactivity.MainActivity


class SpecialFamousAdapter(var context: Context?) :
    ListAdapter<SpecialFamouse, ViewHolder_SpecialFamouse>(DiffCallback_SpecialFamouse()) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder_SpecialFamouse {
        val binding: SpecialFamousItemAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.special_famous_item_adapter, p0, false)

        return ViewHolder_SpecialFamouse(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder_SpecialFamouse, position: Int) {
        holder.bind(context, currentList[position])


    }

}

private class DiffCallback_SpecialFamouse : DiffUtil.ItemCallback<SpecialFamouse>() {

    override fun areItemsTheSame(
        oldItem: SpecialFamouse, newItem: SpecialFamouse
    ) =
        oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: SpecialFamouse, newItem: SpecialFamouse
    ) =
        oldItem == newItem
}


class ViewHolder_SpecialFamouse(
    val binding: SpecialFamousItemAdapterBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(context: Context?, data: SpecialFamouse) {

//        binding.listener = ClickHandler()
        binding.data = data
        binding.context = context as MainActivity?
    }


}
