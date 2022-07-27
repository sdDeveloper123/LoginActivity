package com.reference.codesend

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.reference.codesend.databinding.FragmentSplashBinding
import com.reference.codesend.utils.AppSharePrefrence


class SplashFragment : Fragment() {

 lateinit var binding: FragmentSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater)
        Handler().postDelayed({
                   checkUser()
        }, 3000) // 3000 is the delayed time in milliseconds.

        return binding.root
    }
    fun checkUser() {
        val login = AppSharePrefrence.getLogin(context)
        if (login.equals("false")||login.isNullOrEmpty()){
            this.findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
        }else{
            this.findNavController().navigate(R.id.action_splashFragment_to_dashboardFragment)
        }
    }
}