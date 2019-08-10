package com.example.architecturecomponents.workmanager

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData


open class LiveDataHelper {
    private val _percent = MediatorLiveData<Int>()

    companion object {
        private var liveDataHelper: LiveDataHelper? = null

        @Synchronized
        public fun getInstance(): LiveDataHelper {
            if (liveDataHelper == null)
                liveDataHelper = LiveDataHelper()
            return liveDataHelper as LiveDataHelper
        }
    }



    fun updatePercentage(percentage: Int) {
        _percent.postValue(percentage)
    }

    fun observePercentage(): LiveData<Int> {
        return _percent
    }
}