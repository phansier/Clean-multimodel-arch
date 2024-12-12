package com.example.scanner_impl.domain

import com.example.core.di.general.PerFeature
import com.example.scanner_impl.domain.models.ScannerModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@PerFeature
internal class ScannerInteractorImpl @Inject constructor(private val scannerRepository: ScannerRepository) :
    ScannerInteractor {
    override suspend fun doScannerWork(): ScannerModel {
        val scannerModel = scannerRepository.doScannerLowLevelWork()
        return doSomeLogic(scannerModel)
    }

    private suspend fun doSomeLogic(scannerModel: ScannerModel): ScannerModel {
        delay(3000.milliseconds)
        return scannerModel
    }
}