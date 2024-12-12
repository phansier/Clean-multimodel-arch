package com.example.scanner_impl.routing

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.example.scanner_impl.presentation.view.ScannerHelpFragment
import com.example.scanner_impl.presentation.view.ScannerMainFragment
import kotlinx.serialization.Serializable

@Serializable
data object ScannerMainScreen

@Serializable
internal data object ScannerHelpScreen

fun NavGraphBuilder.createGraph() {
    fragment<ScannerMainFragment, ScannerMainScreen>()
    fragment<ScannerHelpFragment, ScannerHelpScreen>()
}