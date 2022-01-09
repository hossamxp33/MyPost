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
import com.tarweej.mypost.databinding.BestFamousItemAdapterBinding
import com.tarweej.mypost.databinding.TopProductItemAdapterBinding
import com.tarweej.mypost.entites.home.BestFamouse
import com.tarweej.mypost.mainactivity.MainActivity


class BestFamousAdapter(var context: Context?) :
    ListAdapter<BestFamouse, ViewHolder_BestFamous>(DiffCallback_BestFamous()) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder_BestFamous {
        val binding: BestFamousItemAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.best_famous_item_adapter, p0, false)

        return ViewHolder_BestFamous(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder_BestFamous, position: Int) {
        holder.bind(context, currentList[position])


    }

}

private class DiffCallback_BestFamous : DiffUtil.ItemCallback<BestFamouse>() {

    override fun areItemsTheSame(
        oldItem: BestFamouse, newItem: BestFamouse
    ) =
        oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: BestFamouse, newItem: BestFamouse
    ) =
        oldItem == newItem
}


class ViewHolder_BestFamous(
    val binding: BestFamousItemAdapterBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(context: Context?, data: BestFamouse) {

//        binding.listener = ClickHandler()
        binding.data = data
        binding.context = context as MainActivity?

    }


}
