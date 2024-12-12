package com.example.scanner_impl.presentation.presenter

import android.annotation.SuppressLint
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.scanner_impl.domain.ScannerInteractor
import com.example.scanner_impl.presentation.view.ScannerMainView
import com.example.scanner_impl.routing.ScannerRoutingScreens.getScannerHelpScreen
import moxy.InjectViewState
import moxy.MvpPresenter
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
internal class ScannerPresenter @Inject constructor(private val scannerInteractor: ScannerInteractor,
                                                    private val purchaseInteractor: PurchaseInteractor,
                                                    private val router: Router) : MvpPresenter<ScannerMainView>() {
    @SuppressLint("CheckResult")
    fun clickToScannerWork() {
        presenterScope.launch {
            viewState.showScannerWork()
            scannerInteractor.doScannerWork()
            viewState.showScannerSuccess()
        }
    }

    @SuppressLint("CheckResult")
    fun clickToBuyWork() {
        presenterScope.launch {
            viewState.showBuyWork()
            purchaseInteractor.makePurchase()
            viewState.showBuySuccess()
        }
    }

    fun clickToHelp() {
        router.navigateTo(getScannerHelpScreen())
    }
}