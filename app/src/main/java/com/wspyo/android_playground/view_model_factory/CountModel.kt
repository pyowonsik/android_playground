package com.wspyo.android_playground.view_model_factory

import android.util.Log
import androidx.lifecycle.ViewModel


class CountModel(number : Int): ViewModel() {
    init {
        Log.d("CountModel",number.toString())
    }
}