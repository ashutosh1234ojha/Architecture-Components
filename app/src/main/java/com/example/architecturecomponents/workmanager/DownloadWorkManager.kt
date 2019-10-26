package com.example.architecturecomponents.workmanager

import android.content.Context
import android.os.Environment
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.ListenableWorker
import java.net.URL
import java.nio.file.Files.exists
import java.io.File.separator
import android.os.Environment.getExternalStorageDirectory
import android.util.Log
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.MalformedURLException
import java.text.SimpleDateFormat
import java.util.*


class DownloadWorkManager(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    private var liveDataHelper: LiveDataHelper? = null

    init {
        liveDataHelper = LiveDataHelper.getInstance()

    }

    override fun doWork(): ListenableWorker.Result {

        val path = inputData.getString("Download_Path")
        val file_length: Int

        Log.i("Info: path", path)
        try {
            val url = URL(path)
            val urlConnection = url.openConnection()
            urlConnection.connect()
            file_length = urlConnection.contentLength

            val new_folder = File(Environment.getExternalStorageDirectory().absolutePath, "myfolder1")
            if (!new_folder.exists()) {
                if (new_folder.mkdir()) {
                    Log.i("Info", "Folder succesfully created")
                } else {
                    Log.i("Info", "Failed to create folder")
                }
            } else {
                Log.i("Info", "Folder already exists")
            }

            /**
             * Create an output file to store the image for download
             */
            val output_file = File(new_folder, "downloaded_image.jpg")
            val outputStream = FileOutputStream(output_file)

            val inputStream = BufferedInputStream(url.openStream(), 8192)
            val data = ByteArray(1024)
            var total = 0
            var count = inputStream.read(data)

            while (count != -1) {

                total += count

                if (count != -1) {
                    outputStream.write(data, 0, count)
                }
                val progress = 100 * total / file_length

                LiveDataHelper.getInstance().updatePercentage(progress)

                Log.i("Info", "Progress: " + Integer.toString(progress))

                count = inputStream.read(data)
            }
            inputStream.close()
            outputStream.close()

            Log.i("Info", "file_length: " + Integer.toString(file_length))

        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }




        return Result.success()

    }

}