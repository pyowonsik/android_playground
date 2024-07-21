package com.wspyo.android_playground.view_binding_adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wspyo.android_playground.ListViewModel
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.BindingItemBinding
import com.wspyo.android_playground.recyclerview.RVAdapter

class ViewBindingAdapter (val items : MutableList<String>) : RecyclerView.Adapter<ViewBindingAdapter.ViewHolder>(){
    class ViewHolder(binding : BindingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val myText : TextView = binding.bindingText
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingAdapter.ViewHolder {
        val view = BindingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewBindingAdapter.ViewHolder, position: Int) {
        holder.myText.text = items[position]
    }
}