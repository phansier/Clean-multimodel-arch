package com.example.antitheft_impl.presentation.presenter

import android.annotation.SuppressLint
import com.example.antitheft_impl.domain.AntitheftInteractor
import com.example.antitheft_impl.presentation.view.AntitheftMainView
import com.example.antitheft_impl.routing.AntitheftRoutingScreens
import com.example.purchase_api.domain.PurchaseInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
internal class AntitheftPresenter @Inject constructor(private val antitheftInteractor: AntitheftInteractor,
                                                      private val purchaseInteractor: PurchaseInteractor,
                                                      private val router: Router) : MvpPresenter<AntitheftMainView>() {
    @SuppressLint("CheckResult")
    fun clickToAtWork() {
        antitheftInteractor.doAntitheftWork()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showAtWork() }
                .doOnSuccess { viewState.showAtSuccess() }
                .subscribe({ }, { })
    }

    @SuppressLint("CheckResult")
    fun clickToBuyWork() {
        purchaseInteractor.makePurchase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showBuyWork() }
                .doOnSuccess { viewState.showBuySuccess() }
                .subscribe({ }) { }
    }

    fun clickToHelp() {
        router.navigateTo(AntitheftRoutingScreens.getAntitheftHelpScreen())
    }
}