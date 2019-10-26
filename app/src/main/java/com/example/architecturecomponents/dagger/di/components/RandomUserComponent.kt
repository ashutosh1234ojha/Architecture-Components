package com.example.architecturecomponents.dagger.di.components

import com.example.architecturecomponents.dagger.RandomUsersApi
import com.example.architecturecomponents.dagger.di.moduels.PicassoModule
import com.example.architecturecomponents.dagger.di.moduels.RandomUsersModule
import com.squareup.picasso.Picasso
import dagger.Component

@Component(modules = arrayOf(RandomUsersModule::class, PicassoModule::class))
interface RandomUserComponent {
    fun getRandomUserService(): RandomUsersApi
    fun getPicasso(): Picasso
}