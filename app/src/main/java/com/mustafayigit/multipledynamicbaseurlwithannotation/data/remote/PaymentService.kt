package com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
interface PaymentService {

    @POST("payment")
    suspend fun pay(
        @Body details: JsonObject
    ): Response<Boolean>

}