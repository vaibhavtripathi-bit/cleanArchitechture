package com.example.myinternationalapp.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.IOException
import java.io.InputStream
// Added to read data from local to mock the data from API.
class FileUtil<T> {

    companion object {
        var shouldLoadLocalData = false
        fun <T> loadJSONResponseFromAsset(context: Context, fileName: String, responseClass: Class<T>): T? {
            var json: String? = null
            json = try {
                val `is`: InputStream = context.assets.open(fileName)
                val size = `is`.available()
                val buffer = ByteArray(size)
                `is`.read(buffer)
                `is`.close()
                String(buffer)
            } catch (ex: IOException) {
                Log.e("Exception", ex.localizedMessage)
                return null
            }
            return try {
                Gson().fromJson(json, responseClass)
            } catch (ex: JsonSyntaxException) {
                Log.e("Exception", ex.localizedMessage)
                null
            }
        }
    }
}
