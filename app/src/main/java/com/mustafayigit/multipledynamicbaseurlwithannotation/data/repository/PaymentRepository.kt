package com.mustafayigit.multipledynamicbaseurlwithannotation.data.repository

import com.google.gson.JsonObject
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.remote.PaymentService
import com.mustafayigit.multipledynamicbaseurlwithannotation.util.ResponseWrapper
import javax.inject.Inject


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
class PaymentRepository @Inject constructor(
    private val paymentService: PaymentService
) {

    suspend fun pay(): ResponseWrapper<Boolean> {
        return try {
            val details = JsonObject().apply {
                addProperty("uuid", "11111")
                addProperty("amount", 100)
                addProperty("deviceId", "11111")
            }
            val response = paymentService.pay(details)
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