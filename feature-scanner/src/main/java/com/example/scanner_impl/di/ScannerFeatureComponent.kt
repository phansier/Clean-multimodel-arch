package com.example.scanner_impl.di

import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import com.example.core.di.general.PerFeature
import com.example.scanner_api.ScannerFeatureApi
import com.example.scanner_api.ScannerFeatureScreen
import com.example.scanner_impl.presentation.view.ScannerActivity
import com.example.scanner_impl.presentation.view.ScannerMainFragment
import dagger.Component

@Component(
    modules = [ScannerFeatureModule::class],
    dependencies = [ScannerFeatureDependencies::class]
)
@PerFeature
internal abstract class ScannerFeatureComponent : ScannerFeatureApi {

    internal abstract fun inject(scannerActivity: ScannerActivity)
    internal abstract fun inject(scannerMainFragment: ScannerMainFragment)

    override fun scannerStarter(): (NavGraphBuilder) -> Unit = { navGraphBuilder ->
        navGraphBuilder.activity<ScannerFeatureScreen> {
            this.activityClass = ScannerActivity::class
        }
    }

    companion object {
        fun initAndGet(scannerFeatureDependencies: ScannerFeatureDependencies): ScannerFeatureComponent {
            return DaggerScannerFeatureComponent.builder()
                .scannerFeatureDependencies(scannerFeatureDependencies)
                .build()

        }
    }
}

