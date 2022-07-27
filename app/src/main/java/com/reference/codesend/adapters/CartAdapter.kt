package com.reference.codesend.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.reference.codesend.ProductFragment
import com.reference.codesend.databinding.ItemCartBinding
import com.reference.codesend.databinding.ItemDasboardOutdoorBinding

class CartAdapter(val context: Context?):RecyclerView.Adapter<CartAdapter.MyViewHolder>(){
    var size = 6;

    class MyViewHolder(binding: ItemCartBinding):RecyclerView.ViewHolder(binding.root) {
            var x = binding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartAdapter.MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.x.delete.setOnClickListener(){
           --size
           notifyItemRemoved(position)
           notifyDataSetChanged()
           Toast.makeText(context,"DELETED",Toast.LENGTH_SHORT).show()
       }
        //total += holder.x.tvPrice.text.toString()
    }

    override fun getItemCount(): Int {
      return size
    }
}