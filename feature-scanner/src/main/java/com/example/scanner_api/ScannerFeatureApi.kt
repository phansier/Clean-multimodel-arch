package com.example.scanner_api

import androidx.navigation.NavGraphBuilder
import com.example.module_injector.BaseAPI
import kotlinx.serialization.Serializable

interface ScannerFeatureApi : BaseAPI {
    fun scannerStarter(): (NavGraphBuilder) -> Unit
}

@Serializable
data object ScannerFeatureScreen
