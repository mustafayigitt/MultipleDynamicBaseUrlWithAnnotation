package com.mustafayigit.multipledynamicbaseurlwithannotation.base

import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.ApiType

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Api(
    val value: ApiType
)
