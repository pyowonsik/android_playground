package com.wspyo.android_playground.access_view

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wspyo.android_playground.R

class FindViewByIdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_view_by_id)

        findViewById<Button>(R.id.findViewByIdBtn1).text = "abcd"
        findViewById<Button>(R.id.findViewByIdBtn2).text = "abcd"
        findViewById<Button>(R.id.findViewByIdBtn3).text = "abcd"

    }
}