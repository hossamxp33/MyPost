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
import com.tarweej.mypost.databinding.CertifiedFamousItemAdapterBinding

import com.tarweej.mypost.entites.home.BestFamouse
import com.tarweej.mypost.entites.home.CertifiedFamouse
import com.tarweej.mypost.mainactivity.MainActivity


class CertifiedFamousAdapter(var context: Context?) :
    ListAdapter<CertifiedFamouse, ViewHolder_CertifiedFamous>(DiffCallback_CertifiedFamous()) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder_CertifiedFamous {
        val binding: CertifiedFamousItemAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.certified_famous_item_adapter, p0, false)

        return ViewHolder_CertifiedFamous(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder_CertifiedFamous, position: Int) {
        holder.bind(context, currentList[position])


    }

}

private class DiffCallback_CertifiedFamous : DiffUtil.ItemCallback<CertifiedFamouse>() {

    override fun areItemsTheSame(
        oldItem: CertifiedFamouse, newItem: CertifiedFamouse
    ) =
        oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: CertifiedFamouse, newItem: CertifiedFamouse
    ) =
        oldItem == newItem
}


class ViewHolder_CertifiedFamous(
    val binding: CertifiedFamousItemAdapterBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(context: Context?, data: CertifiedFamouse) {

//        binding.listener = ClickHandler()
        binding.data = data
        binding.context = context as MainActivity?

    }


}
