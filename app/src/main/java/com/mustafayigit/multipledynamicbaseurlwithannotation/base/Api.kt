package com.mustafayigit.multipledynamicbaseurlwithannotation.base

import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.ApiType

/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Api(
    val value: ApiType
)
