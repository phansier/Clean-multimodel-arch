package com.example.scanner_example

import android.app.Application
import com.example.scanner_impl.di.ScannerFeatureComponentHolder
import com.example.scanner_example.di.ScannerFeatureDependenciesFake

class ScannerExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // component
        ScannerFeatureComponentHolder.init(
            ScannerFeatureDependenciesFake()
        )
    }
}