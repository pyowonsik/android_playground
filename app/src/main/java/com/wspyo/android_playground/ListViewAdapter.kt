package com.wspyo.android_playground

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import java.util.zip.Inflater

class ListViewAdapter(val items : MutableList<ListViewModel>, val context : Context) : BaseAdapter(){
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView : View?, parent: ViewGroup?): View {
        var view = convertView
        if(view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.lv_item,parent,false)
        }

        view!!.setOnClickListener{
            Toast.makeText(context,"${items[position].title.toString()} : ${items[position].content.toString()}",Toast.LENGTH_LONG).show()
        }

        var title : TextView = view!!.findViewById(R.id.itemTitle)
        val content : TextView = view!!.findViewById(R.id.itemContent)

        title.text = items[position].title
        content.text = items[position].content

        return view!!
    }
}