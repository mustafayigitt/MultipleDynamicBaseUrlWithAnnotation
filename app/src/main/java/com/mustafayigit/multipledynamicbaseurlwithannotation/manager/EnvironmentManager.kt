package com.mustafayigit.multipledynamicbaseurlwithannotation.manager

import com.mustafayigit.multipledynamicbaseurlwithannotation.data.model.EnvironmentModel
import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.ApiType
import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.DeploymentType


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
object EnvironmentManager {

    val environments = listOf(
        EnvironmentModel(
            apiType = ApiType.AUTH,
            deploymentType = DeploymentType.PRODUCTION
        ),
        EnvironmentModel(
            apiType = ApiType.CONTENT,
            deploymentType = DeploymentType.PRODUCTION
        ),
        EnvironmentModel(
            apiType = ApiType.PAYMENT,
            deploymentType = DeploymentType.BETA
        ),
    )


    fun getBaseUrl(apiType: ApiType): String {
        return environments.find { it.apiType == apiType }!!.baseUrl
    }



}