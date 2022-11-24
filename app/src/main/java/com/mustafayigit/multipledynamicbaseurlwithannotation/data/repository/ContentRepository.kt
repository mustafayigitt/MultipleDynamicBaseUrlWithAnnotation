package com.mustafayigit.multipledynamicbaseurlwithannotation.data.repository

import com.mustafayigit.multipledynamicbaseurlwithannotation.data.model.ContentModel
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote.ContentService
import com.mustafayigit.multipledynamicbaseurlwithannotation.util.ResponseWrapper
import javax.inject.Inject


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
class ContentRepository @Inject constructor(
    private val contentService: ContentService
) {

    suspend fun getContents(): ResponseWrapper<List<ContentModel>> {
        return try {
            val response = contentService.getContents()
            if (response.isSuccessful && response.body() != null) {
                ResponseWrapper.Success(response.body()!!)
            } else {
                ResponseWrapper.Error(response.code(), response.message())
            }
        } catch (e: Exception) {
            ResponseWrapper.NetworkError
        }
    }

}