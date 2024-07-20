package com.wspyo.android_playground.access_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wspyo.android_playground.R

class ViewBindingFragmentActivity : AppCompatActivity() {

    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_binding_fragment)

        val transaction = manager.beginTransaction()
        val fragment = ViewBindingFragment()
        transaction.replace(R.id.frameArea,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}