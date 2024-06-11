package com.wspyo.android_playground.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var  binding : FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false)

        binding.firstF.setOnClickListener{
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        binding.thirdF.setOnClickListener{
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}