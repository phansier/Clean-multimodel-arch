package com.example.scanner_impl.domain

import com.example.core.di.general.PerFeature
import com.example.scanner_impl.domain.models.ScannerModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@PerFeature
internal class ScannerInteractorImpl @Inject constructor(private val scannerRepository: ScannerRepository) : ScannerInteractor {
    override fun doScannerWork(): Single<ScannerModel> {
        return scannerRepository.doScannerLowLevelWork()
                .flatMap { scannerModel: ScannerModel -> doSomeLogic(scannerModel) }
    }

    private fun doSomeLogic(scannerModel: ScannerModel): Single<ScannerModel> {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
                .map { scannerModel }
    }
}