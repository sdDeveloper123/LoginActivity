package com.reference.codesend

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.*
import com.reference.codesend.databinding.FragmentForgetpwBinding
import com.reference.codesend.databinding.FragmentOtpBinding
import com.reference.codesend.utils.AppSharePrefrence


class OtpFragment : Fragment() {

  private lateinit var binding: FragmentOtpBinding
  private lateinit var auth: FirebaseAuth
    lateinit var number:String
    lateinit var id: String
  private val args:OtpFragmentArgs by navArgs()
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

        binding = FragmentOtpBinding.inflate(inflater)
        number = args.phoneNumber.toString()


        binding.btVerifyotp.setOnClickListener(){
            auth=FirebaseAuth.getInstance()
            val otp = binding.tvOtp.text.toString()


          if(otp.isNotEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    number, otp)
                signInWithPhoneAuthCredential(credential)

            }else{
                Toast.makeText(context,"Enter OTP",Toast.LENGTH_SHORT).show()
           }
        }
        return binding.root
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(context as Activity) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                    checkUser()
                }
                    else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(context,"Invalid OTP",Toast.LENGTH_SHORT).show()
                        Log.d("OTP", "ERROR"+task.exception)
                    }
                }
            }
}
    private fun checkUser(){
        val firebaseUser: FirebaseUser? = auth.currentUser
        firebaseUser?.let {
            id = firebaseUser.phoneNumber.toString()
        }

        Log.d("number", id)
        Log.d("number", number)
        val userName = AppSharePrefrence.getUsername(context)
        if(!userName.isNullOrEmpty()){
            this.findNavController().navigate(R.id.action_otpFragment_to_dashboardFragment)
        }else{
            this.findNavController().navigate(R.id.action_otpFragment_to_registerFragment)

        }
    }

}