package com.mustafayigit.multipledynamicbaseurlwithannotation.util


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val value: T) : ResponseWrapper<T>()
    data class Error(val code: Int, val message: String) : ResponseWrapper<Nothing>()
    object NetworkError : ResponseWrapper<Nothing>()
}