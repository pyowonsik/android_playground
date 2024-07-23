package com.wspyo.android_playground.share_view_model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.ActivityShareBinding
import com.wspyo.android_playground.view_model.ViewModelFragment

class ShareActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShareBinding
    private lateinit var myViewModel: MyViewModel
    var manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_share)
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.count.text = myViewModel.getCount()

        binding.plus.setOnClickListener{
            binding.count.text = myViewModel.getCount()
            myViewModel.plusCount()
        }

        binding.minus.setOnClickListener{
            binding.count.text = myViewModel.getCount()
            myViewModel.minusCount()
        }

        binding.showFragment.setOnClickListener{
            val transaction = manager.beginTransaction()
            val fragment = ShareFragment()
            transaction.replace(R.id.frameArea,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }



    }
}