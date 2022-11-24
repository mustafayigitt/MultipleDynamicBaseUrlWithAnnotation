package com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote

import com.mustafayigit.multipledynamicbaseurlwithannotation.data.model.ContentModel
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
interface ContentService {

    @GET("contents")
    suspend fun getContents(): Response<List<ContentModel>>
}