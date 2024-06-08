package com.wspyo.android_playground.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wspyo.android_playground.ListViewModel
import com.wspyo.android_playground.R

class RVAdapter(val items : MutableList<ListViewModel>,context : Context) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    private val context : Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item:ListViewModel){
            val title = itemView.findViewById<TextView>(R.id.itemTitle)
            val content = itemView.findViewById<TextView>(R.id.itemContent)

            itemView.setOnClickListener{
                Toast.makeText(context,"${item.title.toString()} : ${item.content.toString()}",Toast.LENGTH_LONG).show()
            }

            title.text = item.title
            content.text = item.content

        }
    }
}