package com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote

import com.google.gson.JsonObject
import com.mustafayigit.multipledynamicbaseurlwithannotation.base.Api
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.model.AuthModel
import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.ApiType
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
interface AuthService {

    @POST("login")
    @Api(ApiType.AUTH)
    suspend fun login(
        @Body credentials: JsonObject
    ): Response<AuthModel>

}