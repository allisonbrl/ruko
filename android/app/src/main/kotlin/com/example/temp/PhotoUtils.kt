package com.sheero.ruko

import android.content.ContentResolver
import android.provider.MediaStore
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

object PhotoUtils {
    private const val CHANNEL_NAME = "photo_utils"
    private const val IS_DELETABLE_METHOD = "isDeletable"

    fun setupMethodChannel(binaryMessenger: BinaryMessenger, contentResolver: ContentResolver) {
        val channel = MethodChannel(binaryMessenger, CHANNEL_NAME)
        channel.setMethodCallHandler { call, result ->
            handleMethodCall(call, result, contentResolver)
        }
    }

    private fun handleMethodCall(
        call: MethodCall,
        result: MethodChannel.Result,
        contentResolver: ContentResolver,
    ) {
        if (call.method != IS_DELETABLE_METHOD) {
            result.notImplemented()
            return
        }

        val rawIds = call.argument<List<*>>("ids")
        if (rawIds.isNullOrEmpty()) {
            result.error("INVALID_ARGUMENTS", "Expected non-empty 'ids' array", null)
            return
        }

        val ids = rawIds.filterIsInstance<String>()
        if (ids.size != rawIds.size) {
            result.error("INVALID_ARGUMENTS", "The 'ids' array must contain only strings", null)
            return
        }

        result.success(getDeletableIds(ids, contentResolver))
    }

    private fun getDeletableIds(ids: List<String>, contentResolver: ContentResolver): List<String> {
        val numericIds = ids.mapNotNull { it.toLongOrNull() }
        if (numericIds.isEmpty()) {
            return ids
        }

        val existingIds = mutableSetOf<String>()
        existingIds += queryExistingIds(
            contentResolver = contentResolver,
            collection = MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            numericIds = numericIds,
        )
        existingIds += queryExistingIds(
            contentResolver = contentResolver,
            collection = MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            numericIds = numericIds,
        )

        if (existingIds.isEmpty()) {
            return ids
        }

        return ids.filter { it in existingIds }
    }

    private fun queryExistingIds(
        contentResolver: ContentResolver,
        collection: android.net.Uri,
        numericIds: List<Long>,
    ): Set<String> {
        val placeholders = numericIds.joinToString(",") { "?" }
        val selection = "${MediaStore.MediaColumns._ID} IN ($placeholders)"
        val args = numericIds.map { it.toString() }.toTypedArray()
        val found = mutableSetOf<String>()

        contentResolver.query(
            collection,
            arrayOf(MediaStore.MediaColumns._ID),
            selection,
            args,
            null,
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID)
            while (cursor.moveToNext()) {
                found += cursor.getLong(idColumn).toString()
            }
        }

        return found
    }
}
