package com.wspyo.android_playground.access_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.FragmentDataBindingBinding
import com.wspyo.android_playground.databinding.FragmentFirstBinding

class DataBindingFragment : Fragment() {

    private  lateinit var  binding : FragmentDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_data_binding,container,false)

        binding.fragmentText.text = "Fragment : Data Binding 성공"

        // Inflate the layout for this fragment
        return binding.root
    }

}