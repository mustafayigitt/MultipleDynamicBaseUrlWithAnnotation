package com.mustafayigit.multipledynamicbaseurlwithannotation.data.model

import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.ApiType
import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.DeploymentType


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
data class EnvironmentModel(
    val apiType: ApiType,
    val deploymentType: DeploymentType
) {

    var baseUrl = ""

    init {
        setBaseUrl(apiType, deploymentType)
    }

    fun setBaseUrl(
        apiType: ApiType,
        deploymentType: DeploymentType
    ): String {
        val prefix = when (deploymentType) {
            DeploymentType.ALPHA -> "alpha-"
            DeploymentType.BETA -> "beta-"
            DeploymentType.PRODUCTION -> ""
        }
        return "$prefix${apiType.url}"
    }

    override fun toString(): String {
        return baseUrl
    }

}
