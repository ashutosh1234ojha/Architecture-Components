package com.example.architecturecomponents.dagger.di.moduels

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(context: Context) {

    val contextModule: Context = context

    @Provides
    fun context(): Context {

        return contextModule.applicationContext

    }

}