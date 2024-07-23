package com.wspyo.android_playground.view_model

import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    var resultValue : Int = 0

    fun plus() {
        resultValue++
    }

    fun minus() {
        resultValue--
    }

    fun getResult() : Int {
        return resultValue;
    }
}