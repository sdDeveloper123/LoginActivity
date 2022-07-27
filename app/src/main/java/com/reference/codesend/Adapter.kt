package com.reference.codesend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reference.codesend.databinding.ItemDashboardAllBinding

class Adapter(private val onClickListener: OnClickListener):RecyclerView.Adapter<Adapter.MyViewHolder>(){
    class MyViewHolder(binding:ItemDashboardAllBinding):RecyclerView.ViewHolder(binding.root) {
     var x = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemDashboardAllBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener(){
            onClickListener.onClick()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
    class OnClickListener(val clickListener: () -> Unit) {
        fun onClick() = clickListener()
    }
}