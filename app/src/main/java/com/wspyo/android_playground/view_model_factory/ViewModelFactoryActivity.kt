package com.wspyo.android_playground.view_model_factory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wspyo.android_playground.R

class ViewModelFactoryActivity : AppCompatActivity() {
    private lateinit var countModel: CountModel
    private lateinit var countModelFactory: CountModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_factory)

        // Activity -> ViewModelFactory
        countModelFactory = CountModelFactory(5000)
        countModel = ViewModelProvider(this,countModelFactory).get(CountModel::class.java)
    }
}