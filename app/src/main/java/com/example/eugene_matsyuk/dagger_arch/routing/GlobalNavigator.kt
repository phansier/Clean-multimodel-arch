package com.example.eugene_matsyuk.dagger_arch.routing

import android.content.Context
import com.example.antitheft_api.AntitheftFeatureApi
import com.example.scanner_api.ScannerFeatureApi
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Screen
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class GlobalNavigator @Inject constructor(
        private val featureScanner: Provider<ScannerFeatureApi>,
        private val featureAntitheft: Provider<AntitheftFeatureApi>,
        private val context: Context
) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        for (command in commands) {
            applyCommand(command)
        }
    }
    private fun applyCommand(command: Command) {
        if (command is Forward) {
            forward(command)
            return
        }
        throw RuntimeException("Unexpected action")
    }

    private fun forward(command: Forward) {
        val name = command.screen
        startFeatureStartPoint(name)
    }

    private fun startFeatureStartPoint(screen: Screen) {
        when (screen) {
            GlobalScreenNames.ScannerFeatureScreen -> {
                featureScanner.get().scannerStarter().start(context)
                return
            }
            GlobalScreenNames.AvFeatureScreen -> {
                featureAntitheft.get().antitheftStarter().start(context)
                return
            }
            else -> throw RuntimeException("Unexpected screen: $screen")
        }
    }
}