package com.wspyo.android_playground

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.wspyo.android_playground.databinding.ActivityFindViewByIdTestBinding

class FindViewByIdTestActivity : AppCompatActivity() {

    private val TAG = FindViewByIdTestActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_find_view_by_id_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val binding: ActivityFindViewByIdTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_find_view_by_id_test)


        // findByView
        val FBVText : TextView = findViewById(R.id.FBVText)
        val FBVBtn : Button = findViewById(R.id.FBVBtn)

        FBVText.setOnClickListener{
            Log.d(TAG,FBVText.text.toString())
        }

        FBVBtn.setOnClickListener{
            Log.d(TAG,FBVBtn.text.toString())
        }

        // dataBinding
        val DBText : TextView = binding.DBText
        val DBBtn : Button = binding.DBBtn


        DBText.setOnClickListener{
            Log.d(TAG,DBText.text.toString())
        }

        DBBtn.setOnClickListener{
            Log.d(TAG,DBBtn.text.toString())
        }
    }
}