package com.wspyo.android_playground.view_model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.common.util.DataUtils
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.FragmentViewModelBinding

class ViewModelFragment : Fragment() {

    private lateinit var binding : FragmentViewModelBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_view_model,container,false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.result.text = viewModel.resultValue.toString()

        binding.plus.setOnClickListener{
            viewModel.plus()
            binding.result.text = viewModel.resultValue.toString()
        }

        binding.minus.setOnClickListener{
            viewModel.minus()
            binding.result.text = viewModel.resultValue.toString()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}