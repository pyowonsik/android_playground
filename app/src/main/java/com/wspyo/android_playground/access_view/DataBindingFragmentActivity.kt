package com.wspyo.android_playground.access_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wspyo.android_playground.R

class DataBindingFragmentActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding_fragment)

        val transaction = manager.beginTransaction()
        val fragment = DataBindingFragment()
        transaction.replace(R.id.frameArea,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}