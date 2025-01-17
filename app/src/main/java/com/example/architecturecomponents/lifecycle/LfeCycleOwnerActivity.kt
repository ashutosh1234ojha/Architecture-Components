package com.example.architecturecomponents.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.architecturecomponents.R

class LfeCycleOwnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_owner)
        val lifecycleObserver = ActivityLifeCycleObserver(lifecycle)
        lifecycle.addObserver(lifecycleObserver)

        supportFragmentManager.beginTransaction().replace(R.id.flContainer, LifeCycleOwnerFragment()).commit()


    }
}