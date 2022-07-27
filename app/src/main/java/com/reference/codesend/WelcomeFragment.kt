package com.reference.codesend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.reference.codesend.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
   private lateinit var binding:FragmentWelcomeBinding
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
        binding = FragmentWelcomeBinding.inflate(inflater)
        binding.btLogin.setOnClickListener(){
            this.findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
        binding.btRegister.setOnClickListener(){
            this.findNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
        }
        return binding.root
    }
}