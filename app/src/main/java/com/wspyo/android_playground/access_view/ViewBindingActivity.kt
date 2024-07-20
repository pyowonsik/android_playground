package com.wspyo.android_playground.access_view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wspyo.android_playground.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.viewBindingText.text = "Activity : View Binding 성공"

        binding.viewBindingText.setOnClickListener{
            startActivity(Intent(this,ViewBindingFragmentActivity::class.java))
        }

    }
}