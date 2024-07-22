package com.wspyo.android_playground.view_model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wspyo.android_playground.R
import com.wspyo.android_playground.access_view.DataBindingFragment

class ViewModelFragmentActivity : AppCompatActivity() {

    var manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_fragment)


        if(savedInstanceState == null) {
            val transaction = manager.beginTransaction()
            val fragment = ViewModelFragment()
            transaction.replace(R.id.frameArea,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


}