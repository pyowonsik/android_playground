package com.wspyo.android_playground.share_view_model

import androidx.lifecycle.ViewModel


class MyViewModel : ViewModel() {

    var count = 0

    fun plusCount() {
        count++
    }

    fun minusCount(){
        count--
    }

    fun getCount() : String{
        return count.toString()
    }

}