package com.reference.codesend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.reference.codesend.databinding.FragmentProductBinding
import com.reference.codesend.utils.AppSharePrefrence
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class ProductFragment : Fragment() {

     lateinit var binding: FragmentProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater)
        quantity()

        onClick()
        imageSlider()
        return binding.root
    }
    private fun quantity(){
        binding.tvQuntity.text = 1.toString()
        var price:Int = binding.tvPrice.text.toString().toInt()
        var quantity: Int = binding.tvQuntity.text.toString().toInt()
        quantity = 1
        binding.imgPlus.setOnClickListener(){
            binding.tvQuntity.text = (++quantity).toString()
            binding.tvPrice.text = (price*quantity).toString()
        }
        binding.minus.setOnClickListener(){
            if(quantity>1){
            binding.tvQuntity.text = (--quantity).toString()
                binding.tvPrice.text = (price*quantity).toString()
        }}
    }
    private fun onClick(){
        val address = AppSharePrefrence.getAdAdress(context)
        binding.imgBack.setOnClickListener(){
            this.findNavController().navigate(R.id.action_productFragment_to_dashboardFragment)
        }
        binding.btCheckout.setOnClickListener(){
            if(!address.isNullOrEmpty()){
            this.findNavController().navigate(R.id.action_productFragment_to_cartFragment)
        }else{
            this.findNavController().navigate(R.id.action_productFragment_to_addressFragment)
        }
        }
    }
    private fun imageSlider(){
       binding.imageView3.addData(CarouselItem("https://images.unsplash.com/photo-1485955900006-10f4d324d411?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8cG90fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60"))
        binding.imageView3.addData(CarouselItem("https://images.unsplash.com/photo-1509423350716-97f9360b4e09?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTl8fHBvdHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"))
        binding.imageView3.addData(CarouselItem("https://images.unsplash.com/photo-1507988914355-bf49fdbc7368?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHBvdHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"))
    }
}

