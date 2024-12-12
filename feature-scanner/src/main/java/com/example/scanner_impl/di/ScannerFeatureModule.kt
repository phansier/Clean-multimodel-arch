package com.example.scanner_impl.di

import com.example.core.di.general.PerFeature
import com.example.scanner_impl.data.ScannerRepositoryImpl
import com.example.scanner_impl.domain.ScannerInteractor
import com.example.scanner_impl.domain.ScannerInteractorImpl
import com.example.scanner_impl.domain.ScannerRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class ScannerFeatureModule {
    @PerFeature
    @Binds
    abstract fun provideScannerRepository(scannerRepository: ScannerRepositoryImpl): ScannerRepository
    @PerFeature
    @Binds
    abstract fun provideScannerInteractor(scannerInteractor: ScannerInteractorImpl): ScannerInteractor
}