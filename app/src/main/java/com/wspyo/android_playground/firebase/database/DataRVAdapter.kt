package com.wspyo.android_playground.firebase.database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wspyo.android_playground.ListViewModel
import com.wspyo.android_playground.R



class DataRVAdapter(val items : MutableList<DataModel>, context : Context) : RecyclerView.Adapter<DataRVAdapter.ViewHolder>(){

    private val context : Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataRVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DataRVAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: DataModel){
            val title = itemView.findViewById<TextView>(R.id.itemTitle)
            val content = itemView.findViewById<TextView>(R.id.itemContent)

            itemView.setOnClickListener{
                Toast.makeText(context,"${item.title.toString()} : ${item.content.toString()}",
                    Toast.LENGTH_LONG).show()
            }

            title.text = item.title
            content.text = item.content

        }
    }
}