package com.wspyo.android_playground.access_view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wspyo.android_playground.R

class AccessViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_view)

        findViewById<Button>(R.id.findViewByIdBtn).setOnClickListener{
            startActivity(Intent(this,FindViewByIdActivity::class.java))
        }

        findViewById<Button>(R.id.kotlinExtensionsBtn).setOnClickListener{
            startActivity(Intent(this,KotlinExtensionsActivity::class.java))
        }

        findViewById<Button>(R.id.viewBindingBtn).setOnClickListener{
            startActivity(Intent(this,ViewBindingActivity::class.java))
        }

    }
}