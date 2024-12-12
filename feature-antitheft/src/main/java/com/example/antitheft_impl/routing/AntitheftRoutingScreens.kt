package com.example.antitheft_impl.routing

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.example.antitheft_impl.presentation.view.AntitheftHelpFragment
import com.example.antitheft_impl.presentation.view.AntitheftMainFragment
import kotlinx.serialization.Serializable

@Serializable
data object AntitheftMainScreen

@Serializable
internal data object AntitheftHelpScreen

internal fun NavGraphBuilder.createGraph() {
    fragment<AntitheftMainFragment, AntitheftMainScreen>()
    fragment<AntitheftHelpFragment, AntitheftHelpScreen>()
}