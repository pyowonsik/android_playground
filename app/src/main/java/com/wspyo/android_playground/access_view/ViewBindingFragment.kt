package com.wspyo.android_playground.access_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.FragmentViewBindingBinding

class ViewBindingFragment : Fragment() {

    private var _binding : FragmentViewBindingBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentViewBindingBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.fragmentText.text = "Fragment : View Binding 성공"

        return view
    }
}