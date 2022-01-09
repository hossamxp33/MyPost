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
import com.tarweej.mypost.databinding.TopProductItemAdapterBinding
import com.tarweej.mypost.entites.home.CustomerFamouse
import com.tarweej.mypost.entites.home.Product
import com.tarweej.mypost.mainactivity.MainActivity


class SpecialCustomerAdapter(var context: Context?) :
    ListAdapter<CustomerFamouse, SpecialCustomerViewHolder>(DiffCallbackSpecialCustomer()) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SpecialCustomerViewHolder {
        val binding: SpecialCustomerItemAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.special_customer_item_adapter, p0, false)

        return SpecialCustomerViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SpecialCustomerViewHolder, position: Int) {
        holder.bind(context, currentList[position])


    }

}

private class DiffCallbackSpecialCustomer : DiffUtil.ItemCallback<CustomerFamouse>() {

    override fun areItemsTheSame(
        oldItem: CustomerFamouse, newItem: CustomerFamouse
    ) =
        oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: CustomerFamouse, newItem: CustomerFamouse
    ) =
        oldItem == newItem
}


class SpecialCustomerViewHolder(
    val binding: SpecialCustomerItemAdapterBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(context: Context?, data: CustomerFamouse) {

    //    binding.listener = ClickHandler()
        binding.data = data
        binding.context = context as MainActivity?
    }


}
