package com.mustafayigit.multipledynamicbaseurlwithannotation.data.repository

import com.google.gson.JsonObject
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote.AuthService
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.model.AuthModel
import com.mustafayigit.multipledynamicbaseurlwithannotation.util.ResponseWrapper
import javax.inject.Inject


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */

class AuthRepository @Inject constructor(
    private val authService: AuthService
) {

    suspend fun login(
        username: String,
        password: String
    ): ResponseWrapper<AuthModel> {

        return try {
            val credentials = JsonObject().apply {
                addProperty("username", username)
                addProperty("password", password)
            }
            val response = authService.login(credentials)
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