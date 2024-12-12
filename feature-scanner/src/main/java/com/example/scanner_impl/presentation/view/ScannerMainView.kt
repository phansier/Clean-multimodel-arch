package com.example.scanner_impl.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
internal interface ScannerMainView : MvpView {
    fun showScannerWork()

    fun showScannerSuccess()

    fun showBuyWork()

    fun showBuySuccess()

    fun navigate(route: Any)
}