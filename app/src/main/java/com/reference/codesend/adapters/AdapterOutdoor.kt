package com.reference.codesend.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reference.codesend.Adapter
import com.reference.codesend.databinding.ItemDasboardOutdoorBinding
import com.reference.codesend.databinding.ItemDashboardAllBinding

class AdapterOutdoor():RecyclerView.Adapter<AdapterOutdoor.MyViewHolder>() {
    class MyViewHolder(binding: ItemDasboardOutdoorBinding):RecyclerView.ViewHolder(binding.root) {
        var x = binding
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterOutdoor.MyViewHolder {
        val binding = ItemDasboardOutdoorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterOutdoor.MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterOutdoor.MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
       return 20
    }
}