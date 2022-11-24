package com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote

import com.google.gson.JsonObject
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.model.AuthModel
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
interface AuthService {

    @GET("login")
    suspend fun login(
        credentials: JsonObject
    ): Response<AuthModel>

}