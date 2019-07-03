package com.example.architecturecomponents

import android.content.Context
import android.view.View

object Utility {


    fun setOnClickListener(listener: View.OnClickListener, vararg views: View) {

        for(view in views){
            view.setOnClickListener(listener)
        }
    }
}