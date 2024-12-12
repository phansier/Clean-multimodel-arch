package com.example.antitheft_impl.routing

import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.example.antitheft_impl.presentation.view.AntitheftHelpFragment
import com.example.antitheft_impl.presentation.view.AntitheftMainFragment
import kotlinx.serialization.Serializable


internal object AntitheftScreenNames {
    @Serializable data object AntitheftMainScreen
    @Serializable data object AntitheftHelpScreen
}

internal fun createGraph(navController: NavController) = navController.createGraph(
    startDestination = AntitheftScreenNames.AntitheftMainScreen
) {
    fragment<AntitheftMainFragment, AntitheftScreenNames.AntitheftMainScreen>()
    fragment<AntitheftHelpFragment, AntitheftScreenNames.AntitheftHelpScreen>()
}
