package com.example.antitheft_api

import androidx.navigation.NavGraphBuilder
import com.example.module_injector.BaseAPI
import kotlinx.serialization.Serializable

interface AntitheftFeatureApi: BaseAPI {
    fun antitheftStarter(): (NavGraphBuilder) -> Unit
}

@Serializable
data object AtFeatureScreen
