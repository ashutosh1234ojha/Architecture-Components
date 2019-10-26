package com.example.architecturecomponents.dagger.di.moduels

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import kotlin.math.log
import timber.log.Timber


@Module(includes = arrayOf(ContextModule::class))
class OkHttpClientModule {

    @Provides
    fun okHttpClient(cache: Cache, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

        return OkHttpClient().newBuilder()
            .cache(cache)
            .addInterceptor(httpLoggingInterceptor)
            .build()

    }

    @Provides
    fun cache(file: File): Cache {
        return Cache(file, 10 * 1000 * 1000)
    }

    @Provides
    fun file(context: Context): File {
        val file = File(context.cacheDir, "HttpCache")
        file.mkdirs()
        return file
    }


    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.d(message)
            }
        })
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }
}