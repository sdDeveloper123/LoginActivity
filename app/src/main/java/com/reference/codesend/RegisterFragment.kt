package com.reference.codesend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.reference.codesend.databinding.FragmentRegisterBinding
import com.reference.codesend.utils.AppSharePrefrence


class RegisterFragment : Fragment() {

    private lateinit var x: FragmentRegisterBinding
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
        x = FragmentRegisterBinding.inflate(inflater)
        x.imgBack.setOnClickListener(){
            findNavController().navigateUp()
        }
        saveDetails()
        return x.root
    }

    fun saveDetails(){
        val username = x.etUsername.text
        val email = x.etEmail.text
        x.btLogin.setOnClickListener(){

            AppSharePrefrence.setLogin("true",context)
           if(username?.isEmpty() == true|| email?.isEmpty() == true){
               Toast.makeText(context, "Please fill all details", Toast.LENGTH_LONG).show()
           }else {
               AppSharePrefrence.apply {
                   setEmail(email.toString(), activity)
                   setUsername(username.toString(), activity)
                  setLogin("true",activity)

               }
               this.findNavController().navigate(R.id.dashboardFragment)
           }
        }
    }

}