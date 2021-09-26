package com.example.eugene_matsyuk.dagger_arch.presentation.main.presenter

import com.example.eugene_matsyuk.dagger_arch.di.DiConstants.GLOBAL
import com.example.eugene_matsyuk.dagger_arch.presentation.main.view.MainView
import com.example.eugene_matsyuk.dagger_arch.routing.GlobalScreenNames.AvFeatureScreen
import com.example.eugene_matsyuk.dagger_arch.routing.GlobalScreenNames.ScannerFeatureScreen
import moxy.InjectViewState
import moxy.MvpPresenter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class MainPresenter @Inject constructor(@param:Named(GLOBAL) private val router: Router) : MvpPresenter<MainView>() {
    fun clickToScanner() {
        router.navigateTo(ScannerFeatureScreen)
    }

    fun clickToAntiTheft() {
        router.navigateTo(AvFeatureScreen)
    }
}