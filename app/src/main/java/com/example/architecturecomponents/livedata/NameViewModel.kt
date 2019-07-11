package com.example.architecturecomponents.livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class NameViewModel : ViewModel() {
     var name: MutableLiveData<String>?=null

    fun getUserName(): MutableLiveData<String> {
        if(name==null){
            name=MutableLiveData()
        }
        return name as MutableLiveData<String>

    }

    fun  setUserName( useName:String){
        name?.value =useName
    }


}