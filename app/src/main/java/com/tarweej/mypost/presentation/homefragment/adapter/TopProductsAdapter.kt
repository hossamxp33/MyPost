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
import com.tarweej.mypost.databinding.TopProductItemAdapterBinding
import com.tarweej.mypost.entites.home.Product
import com.tarweej.mypost.mainactivity.MainActivity


class TopProductsAdapter(var context: Context?) :
    ListAdapter<Product, ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding: TopProductItemAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.top_product_item_adapter, p0, false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, currentList[position])


    }

}

private class DiffCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(
        oldItem: Product, newItem: Product
    ) =
        oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: Product, newItem: Product
    ) =
        oldItem == newItem
}


class ViewHolder(
    val binding: TopProductItemAdapterBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(context: Context?, data: Product) {

    //    binding.listener = ClickHandler()
        binding.data = data
        binding.context = context as MainActivity?
    }


}
