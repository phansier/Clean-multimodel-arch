package com.example.scanner_impl.domain

import com.example.scanner_impl.domain.models.ScannerModel

internal interface ScannerRepository {
    suspend fun doScannerLowLevelWork(): ScannerModel
}