package com.wspyo.android_playground.view_model

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.wspyo.android_playground.R


// view model : 안드로이드 생명주기를 관리하기 쉽다.

// onSaveInstanceState() 사용해서 데이터를 관리할 수 있지만 적적하지 않다.

// 안드로이드 생명주기를 관리하기 쉽다라는 말과 같은 말인데
// 상태(LifeCylce)가 변경될 때 마다 데이터를 관리해줘야 하는데
// 이 관리가 편하다.

// UI 컨트롤러(액티비티,프래그먼트) 모든 것을 다하려고 하면 복잡해진다.
// 그래서 ViewModel을 사용하면 테스트나 관리가 용이하다.


class ViewModelActivity : AppCompatActivity() {


//    private var resultValue = 0
   private lateinit var viewModel : ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        Log.d("ViewModelActivity","onCreate")

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        val result = findViewById<TextView>(R.id.result)
        val plusBtn = findViewById<Button>(R.id.plus)
        val minusBtn = findViewById<Button>(R.id.minus)

        result.text = viewModel.resultValue.toString()


        plusBtn.setOnClickListener{
            viewModel.plus()
            result.text = viewModel.resultValue.toString()
//            resultValue++
//            result.text = resultValue.toString()
        }

        minusBtn.setOnClickListener {
            viewModel.minus()
            result.text = viewModel.resultValue.toString()
//            resultValue--
//            result.text = resultValue.toString()
        }
    }

    override fun onStart() {
        Log.d("ViewModelActivity","onStart")
        super.onStart()
    }
    override fun onResume() {
        Log.d("ViewModelActivity","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("ViewModelActivity","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("ViewModelActivity","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("ViewModelActivity","onDestroy")
        super.onDestroy()
    }
}