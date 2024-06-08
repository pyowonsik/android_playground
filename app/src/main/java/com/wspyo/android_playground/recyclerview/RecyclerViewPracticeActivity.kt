package com.wspyo.android_playground.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wspyo.android_playground.ListViewModel
import com.wspyo.android_playground.R

class RecyclerViewPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_practice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val items = mutableListOf<ListViewModel>()
        items.add(ListViewModel("나이키","조던"))
        items.add(ListViewModel("아디다스","슈퍼스타"))
        items.add(ListViewModel("뉴발란스","574"))
        items.add(ListViewModel("반스","어센틱"))

        val rv : RecyclerView  = findViewById(R.id.rv)
        rv.adapter = RVAdapter(items,this)

        rv.layoutManager = LinearLayoutManager(this)

    }
}