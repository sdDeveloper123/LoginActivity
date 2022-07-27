package com.reference.codesend

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.reference.codesend.databinding.FragmentForgetpwBinding
import com.reference.codesend.databinding.FragmentLoginBinding
import com.reference.codesend.databinding.FragmentWelcomeBinding
import com.reference.codesend.utils.AppSharePrefrence
import java.util.concurrent.TimeUnit


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    lateinit var number: String
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
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
        binding = FragmentLoginBinding.inflate(inflater)
        number= binding.etNumber.text.toString()
        binding.imgBack.setOnClickListener() {
            findNavController().navigateUp()
        }
        binding.tvRegister.setOnClickListener() {
            this.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.tvForgetPassword.setOnClickListener() {
            this.findNavController().navigate(R.id.action_loginFragment_to_forgetpwFragment)
        }
        onBackPress()
        binding.btSend.setOnClickListener() {
            binding.progressBar.visibility = View.VISIBLE

            auth = FirebaseAuth.getInstance()
            login()
        }

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                    findNavController().navigate(
                        ForgetpwFragmentDirections.actionForgetpwFragmentToOtpFragment(
                            number
                        )
                    )
                binding.progressBar.visibility = View.GONE
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(context, "Failed" + e, Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {

                Log.d("TAG", "onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendToken = token

                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToOtpFragment(
                        verificationId
                    )
                )

            }
        }
        return binding.root

    }


    private fun onBackPress() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            callback
        )
    }

    private fun login() {
        number = binding.etNumber.text.toString()
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+91$number") // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(context as Activity) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}