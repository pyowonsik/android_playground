package com.wspyo.android_playground

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FindViewByIdTestActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_find_view_by_id_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text : TextView = findViewById(R.id.textView)
        val button1 : Button = findViewById(R.id.button1)
        val button2 : Button = findViewById(R.id.button2)

        text.setOnClickListener{
            Log.d(TAG,text.text.toString())
        }

        button1.setOnClickListener{
            Log.d(TAG,button1.text.toString())
        }

        button2.setOnClickListener{
            Log.d(TAG,button1.text.toString())
        }
    }
}