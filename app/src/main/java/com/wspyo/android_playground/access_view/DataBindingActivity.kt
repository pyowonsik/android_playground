package com.wspyo.android_playground.access_view

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {
    private lateinit var bindng : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindng = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)

        bindng.dataBindingText.text = "Activity : Data Binding 성공"

        bindng.dataBindingText.setOnClickListener{
            startActivity(Intent(this,DataBindingFragmentActivity::class.java))
        }
    }
}