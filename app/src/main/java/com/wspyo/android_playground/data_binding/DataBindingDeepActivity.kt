package com.wspyo.android_playground.data_binding

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.ActivityDataBindingDeepBinding

class DataBindingDeepActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataBindingDeepBinding

    var myAge = 27
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding_deep)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_deep)

        // View에서 사용할 data에 person 오브젝트를 넣어준다.
        // 이렇게하면 view에서 id값을 따지 않아도 되는 것 같은데 . . .
        val person : Person = Person("pyo",27)
        binding.person = person

    }
    fun myClick(view : View){
        val person : Person = Person("pyo",myAge)
        binding.person = person
        myAge++
    }
}