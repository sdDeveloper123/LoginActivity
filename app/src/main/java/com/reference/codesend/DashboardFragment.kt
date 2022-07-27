package com.reference.codesend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.reference.codesend.adapters.AdapterOutdoor
import com.reference.codesend.databinding.FragmentDashboardBinding
import com.reference.codesend.databinding.FragmentOtpBinding
import com.reference.codesend.utils.AppSharePrefrence


class DashboardFragment : Fragment() {
    lateinit var binding: FragmentDashboardBinding
    lateinit var adapter: Adapter
    lateinit var adapter2: AdapterOutdoor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater)
        setAdapter()
        menuItem()
        onBackPress()
        outdoor()
        all()
        return binding.root
    }

    private fun setAdapter() {
        binding.recycleView.adapter = Adapter(Adapter.OnClickListener{
            this.findNavController().navigate(R.id.action_dashboardFragment_to_productFragment)
        })
    }

    fun menuItem() {
        binding.imgLogout.setOnClickListener() {
            AppSharePrefrence.setUsername("",context)
            AppSharePrefrence.setLogin("false",context)
            this.findNavController().navigate(R.id.action_dashboardFragment_to_welcomeFragment)
        }
    }

    private fun outdoor() {
        binding.cvOutdoor.setOnClickListener() {
            adapter2 = AdapterOutdoor()
            binding.recycleViewOut.adapter = adapter2
            binding.recycleView.visibility = View.GONE
            binding.recycleViewOut.visibility = View.VISIBLE

            binding.cvOutdoor.setCardBackgroundColor(resources.getColor(R.color.green))
            binding.cvAll.setCardBackgroundColor(resources.getColor(R.color.white))
            binding.tvOutdoor.setTextColor(resources.getColor(R.color.white))
            binding.tvAll.setTextColor(resources.getColor(R.color.black))

        }
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

    private fun all() {
        binding.cvAll.setOnClickListener() {
            binding.recycleView.adapter = Adapter(Adapter.OnClickListener{
                this.findNavController().navigate(R.id.action_dashboardFragment_to_productFragment)
            })
            binding.recycleView.visibility = View.VISIBLE
            binding.recycleViewOut.visibility = View.GONE

            binding.cvOutdoor.setCardBackgroundColor(resources.getColor(R.color.white))
            binding.cvAll.setCardBackgroundColor(resources.getColor(R.color.green))
            binding.tvOutdoor.setTextColor(resources.getColor(R.color.black))
            binding.tvAll.setTextColor(resources.getColor(R.color.white))
                }
        binding.cart.setOnClickListener(){
          this.findNavController().navigate(R.id.action_dashboardFragment_to_cartFragment)
        }
    }
}