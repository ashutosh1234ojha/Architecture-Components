package com.example.architecturecomponents.dagger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.architecturecomponents.R
import com.example.architecturecomponents.dagger.di.moduels.ContextModule
import com.squareup.picasso.Picasso
import com.example.architecturecomponents.dagger.di.components.DaggerRandomUserComponent
import timber.log.Timber
import android.support.annotation.NonNull
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class DaggerMainActivity :AppCompatActivity() {
    var randomUsersApi: RandomUsersApi? = null
    var picasso: Picasso? = null
    var retrofit: Retrofit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.architecturecomponents.R.layout.activity_dagger_main)

        val daggerRandomUserComponent = DaggerRandomUserComponent.builder()
            .contextModule(ContextModule(this))
            .build()
        picasso = daggerRandomUserComponent.getPicasso()
        randomUsersApi = daggerRandomUserComponent.getRandomUserService()

        findViewById<Button>(R.id.btn).setOnClickListener {
            populateUsers()

        }
    }

    private fun populateUsers() {
        val randomUsersCall = randomUsersApi!!.getRandomUsers(10)



        randomUsersCall.enqueue(object : Callback<RandomUsers> {
            override fun onResponse(call: Call<RandomUsers>, response: Response<RandomUsers>) {
                if (response.isSuccessful()) {
//                    mAdapter = RandomUserAdapter()
//                    mAdapter.setItems(response.body().getResults())
//                    recyclerView.setAdapter(mAdapter)

                    Log.d("SizeTimber",response.body()!!.getResults()!!.size.toString())
                }
            }

            override fun onFailure(call: Call<RandomUsers>, t: Throwable) {
                Timber.i(t.message)
                Log.d("SizeTimber","Failure")

            }
        })




    }

    fun getRandomUserService(): RandomUsersApi {
        return retrofit!!.create(RandomUsersApi::class.java)
    }
}