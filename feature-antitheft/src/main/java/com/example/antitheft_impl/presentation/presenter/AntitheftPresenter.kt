package com.example.antitheft_impl.presentation.presenter

import android.annotation.SuppressLint
import com.example.antitheft_impl.domain.AntitheftInteractor
import com.example.antitheft_impl.presentation.view.AntitheftMainView
import com.example.antitheft_impl.routing.AntitheftHelpScreen
import com.example.purchase_api.domain.PurchaseInteractor
import moxy.InjectViewState
import moxy.MvpPresenter

import kotlinx.coroutines.launch
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
internal class AntitheftPresenter
@Inject constructor(
    private val antitheftInteractor: AntitheftInteractor,
    private val purchaseInteractor: PurchaseInteractor,
) : MvpPresenter<AntitheftMainView>() {
    @SuppressLint("CheckResult")
    fun clickToAtWork() {
        presenterScope.launch {
            viewState.showAtWork()
            antitheftInteractor.doAntitheftWork()
            viewState.showAtSuccess()
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
        viewState.navigate(AntitheftHelpScreen)
    }
}