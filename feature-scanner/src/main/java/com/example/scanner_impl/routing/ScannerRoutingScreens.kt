package com.example.scanner_impl.routing

import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.example.scanner_impl.presentation.view.ScannerHelpFragment
import com.example.scanner_impl.presentation.view.ScannerMainFragment
import kotlinx.serialization.Serializable

internal object ScannerScreenNames {
    @Serializable
    data object ScannerMainScreen
    @Serializable
    data object ScannerHelpScreen
}

internal fun createGraph(navController: NavController) = navController.createGraph(
    startDestination = ScannerScreenNames.ScannerMainScreen
) {
    fragment<ScannerMainFragment, ScannerScreenNames.ScannerMainScreen>()
    fragment<ScannerHelpFragment, ScannerScreenNames.ScannerHelpScreen>()
}