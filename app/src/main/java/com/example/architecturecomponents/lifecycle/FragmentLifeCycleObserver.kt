package com.example.architecturecomponents.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class FragmentLifeCycleObserver(private var lifecycle: Lifecycle) : LifecycleObserver {
    private val TAG = "EVENT FRAGMENT"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated() {
        Log.d(TAG, "onCreated")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStarted() {
        Log.d(TAG, "onStarted")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumed() {
        Log.d(TAG, "onResumed")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPaused() {
        Log.d(TAG, "onPaused")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(TAG, "onDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.d(TAG, "onAny")
    }


    fun checkingAtLeastStarted() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {
            //write here what you want to do on or after onCreate event
        }
    }

}