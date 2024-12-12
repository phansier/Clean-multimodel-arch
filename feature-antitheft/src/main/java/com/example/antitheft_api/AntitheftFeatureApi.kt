package com.example.antitheft_api

import androidx.navigation.NavGraphBuilder
import com.example.module_injector.BaseAPI

interface AntitheftFeatureApi: BaseAPI {
    fun antitheftStarter(ngb: NavGraphBuilder)
}
