package com.wesleyadiel.fitnesstrackpro.data.image

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class ImageStorageManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun saveImageToInternalStorage(sourceUri: Uri): String? = withContext(Dispatchers.IO) {
        try {
            val inputStream = context.contentResolver.openInputStream(sourceUri) ?:
                return@withContext null
            val fileName = "body_stats_${System.currentTimeMillis()}.jpg"
            val file = File(context.filesDir, fileName)
            inputStream.use { input ->
                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                }
            }
            file.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun deleteImageFromInternalStorage(path: String?) = withContext(Dispatchers.IO) {
        if (path.isNullOrEmpty()) return@withContext
        try {
            val file = File(path)
            if (file.exists()) {
                file.delete()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}