package com.mustafayigit.multipledynamicbaseurlwithannotation.enums

/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
enum class ApiType(
    val url: String
) {
    AUTH("auth.mydomain.com"),
    CONTENT("mydomain.com"),
    PAYMENT("pay.mydomain.com")
}