package com.example.antitheft_impl.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
internal interface AntitheftMainView : MvpView {

    fun showAtWork()

    fun showAtSuccess()

    fun showBuyWork()

    fun showBuySuccess()

    fun navigate(route: Any)
}