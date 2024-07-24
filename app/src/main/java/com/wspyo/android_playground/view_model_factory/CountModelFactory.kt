package com.wspyo.android_playground.view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CountModelFactory(private val num: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        // ViewModelFactory -> ViewModel
        if(modelClass.isAssignableFrom(CountModel::class.java)){
            return CountModel(num) as T
        }
        throw IllegalAccessException("unknown ViewModel class ")
    }
}