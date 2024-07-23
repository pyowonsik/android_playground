package com.wspyo.android_playground.share_view_model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.FragmentShareBinding


class ShareFragment : Fragment() {

    private lateinit var binding : FragmentShareBinding
    private val myViewModel : MyViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_share, container, false)

        binding.count.text = myViewModel.getCount()

        return binding.root
    }


}