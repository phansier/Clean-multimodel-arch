package com.example.scanner_api

import androidx.navigation.NavGraphBuilder
import com.example.module_injector.BaseAPI

interface ScannerFeatureApi : BaseAPI {
    fun scannerStarter(ngb: NavGraphBuilder)
}

