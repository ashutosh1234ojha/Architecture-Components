package com.example.architecturecomponents.workmanager

import android.arch.lifecycle.Observer
import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.architecturecomponents.R
import android.graphics.drawable.Drawable
import android.os.Environment
import androidx.work.*
import java.io.File


class WorkManagerActivity : AppCompatActivity() {

    var progressBar: ProgressBar? = null
    var ivImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.architecturecomponents.R.layout.activity_work_manager)

        progressBar = findViewById(com.example.architecturecomponents.R.id.ProgressBar)
        ivImage = findViewById(com.example.architecturecomponents.R.id.ivImage)

        val data: Data = Data.Builder()
            .putString(
                "Download_Path",
                "https://www.google.com/logos/2013/estonia_independence_day_2013-1057005.3-hp.jpg"
            )
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(DownloadWorkManager::class.java)
            .setInputData(data)
            .build()

        WorkManager.getInstance().enqueue(oneTimeWorkRequest)
        LiveDataHelper.getInstance().observePercentage()
            .observe(this, Observer<Int> {

                progressBar?.progress = it!!


                if (it == 100) {
                    progressBar?.visibility = View.GONE

                    val folder = File(Environment.getExternalStorageDirectory().getAbsolutePath(), "myfolder")
                    val output_file = File(folder, "downloaded_image.jpg")
                    val path = output_file.toString()
                    ivImage?.setImageDrawable(Drawable.createFromPath(path))
                }
            })

    }


}