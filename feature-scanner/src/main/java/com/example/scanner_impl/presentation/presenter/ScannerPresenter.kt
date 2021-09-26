package com.example.scanner_impl.presentation.presenter

import android.annotation.SuppressLint
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.scanner_impl.domain.ScannerInteractor
import com.example.scanner_impl.presentation.view.ScannerMainView
import com.example.scanner_impl.routing.ScannerRoutingScreens.getScannerHelpScreen
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
internal class ScannerPresenter @Inject constructor(private val scannerInteractor: ScannerInteractor,
                                                    private val purchaseInteractor: PurchaseInteractor,
                                                    private val router: Router) : MvpPresenter<ScannerMainView>() {
    @SuppressLint("CheckResult")
    fun clickToScannerWork() {
        scannerInteractor.doScannerWork()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showScannerWork() }
                .doOnSuccess { viewState.showScannerSuccess() }
                .subscribe({ }, { })
    }

    @SuppressLint("CheckResult")
    fun clickToBuyWork() {
        purchaseInteractor.makePurchase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showBuyWork() }
                .doOnSuccess { viewState.showBuySuccess() }
                .subscribe({ }, { })
    }

    fun clickToHelp() {
        router.navigateTo(getScannerHelpScreen())
    }
}