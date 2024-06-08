package com.wspyo.android_playground

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_practice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val items = mutableListOf<ListViewModel>()
        items.add(ListViewModel("맘스터치","싸이버거"))
        items.add(ListViewModel("롯데리아","크리스피버거"))
        items.add(ListViewModel("맥도날드","베이컨토마토디럭스"))

        val listView : ListView = findViewById(R.id.lv)
        listView.adapter = ListViewAdapter(items, this)

    }
}