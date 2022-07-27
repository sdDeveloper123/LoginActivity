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
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.reference.codesend.adapters.CartAdapter
import com.reference.codesend.databinding.FragmentCartBinding
import com.reference.codesend.utils.AppSharePrefrence
import org.json.JSONObject


class CartFragment : Fragment(), PaymentResultListener {

    lateinit var binding: FragmentCartBinding
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
        binding = FragmentCartBinding.inflate(inflater)
        adapter()
        onClick()
        address()
        return binding.root

            }
    private fun adapter(){
        val total = binding.tvTotal.text
        binding.recycleView.adapter = CartAdapter(context)
    }
     private fun onClick(){
         binding.imgBack.setOnClickListener(){
             this.findNavController().navigate(R.id.action_cartFragment_to_productFragment)
         }
         binding.btPay.setOnClickListener(){
             startPayment()
         }

     }
    private fun startPayment() {


        val co = Checkout()
        co.setKeyID("rzp_test_JZfLbL9JH1Ej3j");
        try {
            val options = JSONObject()
            options.put("name","Go Greenary")
            //You can omit the image option to fetch the image from dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("theme.color", "#2C814E");
            options.put("currency","INR");
            options.put("amount","50000")//pass amount in currency subunits
            ;

            val prefill = JSONObject()
            prefill.put("contact","9876543210")
            options.put("prefill",prefill)
            co.open(this.context as Activity?,options)

        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
            Log.d("razorpay", "startPayment: $e")
        }
    }
    override fun onPaymentError(errorCode: Int, response: String?) {
        Toast.makeText(activity,"Error in payment: ",Toast.LENGTH_LONG).show()

    }

    override fun onPaymentSuccess(razorpayPaymentId: String?) {
        Toast.makeText(activity,"Error in payment: ",Toast.LENGTH_LONG).show()

    }
    private fun address(){
        val name = binding.name
        val address = binding.address
        val city = binding.city
        AppSharePrefrence.apply {
          name.text =  getAdName(context)
            address.text = getAdAdress(context)
        }

        binding.btEdit.setOnClickListener(){
            this.findNavController().navigate(R.id.action_cartFragment_to_addressFragment)
        }
    }
    }
