package com.mustafayigit.multipledynamicbaseurlwithannotation.data.model


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
data class AuthModel(
    val uuid: String,
    val accessToken: String,
    val refreshToken: String,
    val tokenType: String,
    val expiresIn: Int
)