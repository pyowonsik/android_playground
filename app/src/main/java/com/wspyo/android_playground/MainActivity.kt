package com.wspyo.android_playground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wspyo.android_playground.firebase.FireBasePracticeActivity
import com.wspyo.android_playground.fragment.MainFragmentActivity
import com.wspyo.android_playground.recyclerview.RecyclerViewPracticeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bindingBtn).setOnClickListener{
            startActivity(Intent(this,FindViewByIdTestActivity::class.java))
        }


        findViewById<Button>(R.id.intentBtn).setOnClickListener{
            val intent = Intent(this,IntentTestActivity::class.java)
            intent.putExtra("value1", "android play")
            intent.putExtra("value2","2024-06-06")
            startActivity(intent)
        }

        findViewById<Button>(R.id.listViewBtn).setOnClickListener{
            startActivity(Intent(this,ListViewPracticeActivity::class.java))
        }

        findViewById<Button>(R.id.recyclerViewBtn).setOnClickListener{
            startActivity(Intent(this,RecyclerViewPracticeActivity::class.java))
        }

        findViewById<Button>(R.id.fragmentBtn).setOnClickListener{
            startActivity(Intent(this,MainFragmentActivity::class.java))
        }


        findViewById<Button>(R.id.firebaseBtn).setOnClickListener{
            startActivity(Intent(this,FireBasePracticeActivity::class.java))
        }


    }
}