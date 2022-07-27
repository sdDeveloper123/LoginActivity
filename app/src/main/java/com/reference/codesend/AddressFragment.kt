package com.reference.codesend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.reference.codesend.databinding.FragmentAddressBinding
import com.reference.codesend.utils.AppSharePrefrence

class AddressFragment : Fragment() {
   lateinit var binding: FragmentAddressBinding


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
        binding = FragmentAddressBinding.inflate(inflater)
        save()
        onClick()

        return binding.root
    }
    private fun save(){
        var  name = binding.etUsername.text
        val address =binding.etAddress.text
        binding.btSave.setOnClickListener(){
            if(!name.isNullOrEmpty()&&!address.isNullOrEmpty()){
                AppSharePrefrence.apply {
                   setAdName(name.toString(),context)
                    setAdAddress(address.toString(),context)
                }
                this.findNavController().navigateUp()
                }else{
                Toast.makeText(context, "Enter All Details", Toast.LENGTH_LONG).show()
                }
        }
    }
    private fun onClick(){
        binding.imgBack.setOnClickListener(){
            this.findNavController().navigate(R.id.action_addressFragment_to_cartFragment)
        }
    }
}