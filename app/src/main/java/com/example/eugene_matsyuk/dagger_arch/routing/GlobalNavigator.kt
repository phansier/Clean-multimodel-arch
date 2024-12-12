package com.example.eugene_matsyuk.dagger_arch.routing

import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.example.antitheft_api.AntitheftFeatureApi
import com.example.eugene_matsyuk.dagger_arch.presentation.main.view.HomeFragment
import com.example.scanner_api.ScannerFeatureApi
import kotlinx.serialization.Serializable
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class GlobalNavigator @Inject constructor(
    private val featureScanner: Provider<ScannerFeatureApi>,
    private val featureAntitheft: Provider<AntitheftFeatureApi>,
) {

    fun createGraph(navController: NavController) = navController.createGraph(
        startDestination = HomeScreen
    ) {
        featureScanner.get().scannerStarter(this)
        featureAntitheft.get().antitheftStarter(this)
        fragment<HomeFragment, HomeScreen>()
    }
}

@Serializable
data object HomeScreen
