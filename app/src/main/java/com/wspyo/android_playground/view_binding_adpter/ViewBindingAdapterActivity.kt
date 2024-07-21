package com.wspyo.android_playground.view_binding_adpter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.ActivityViewBindingAdapterBinding

class ViewBindingAdapterActivity : AppCompatActivity() {

    lateinit var binding : ActivityViewBindingAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingAdapterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val items = mutableListOf<String>()
        items.add("a")
        items.add("b")
        items.add("c")

        val viewBindingAdapter = ViewBindingAdapter(items)

        val rv = binding.VBrv
        rv.adapter = viewBindingAdapter
        rv.layoutManager = LinearLayoutManager(this)

    }
}