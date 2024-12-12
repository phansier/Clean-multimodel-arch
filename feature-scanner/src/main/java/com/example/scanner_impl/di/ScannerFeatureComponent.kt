package com.example.scanner_impl.di

import androidx.navigation.NavGraphBuilder
import com.example.core.di.general.PerFeature
import com.example.scanner_api.ScannerFeatureApi
import com.example.scanner_impl.presentation.view.ScannerMainFragment
import com.example.scanner_impl.routing.createGraph
import dagger.Component

@Component(
    modules = [ScannerFeatureModule::class],
    dependencies = [ScannerFeatureDependencies::class]
)
@PerFeature
internal abstract class ScannerFeatureComponent : ScannerFeatureApi {

    internal abstract fun inject(scannerMainFragment: ScannerMainFragment)

    override fun scannerStarter(ngb: NavGraphBuilder) {
        ngb.createGraph()
    }

    companion object {
        fun initAndGet(scannerFeatureDependencies: ScannerFeatureDependencies): ScannerFeatureComponent {
            return DaggerScannerFeatureComponent.builder()
                .scannerFeatureDependencies(scannerFeatureDependencies)
                .build()

        }
    }
}

