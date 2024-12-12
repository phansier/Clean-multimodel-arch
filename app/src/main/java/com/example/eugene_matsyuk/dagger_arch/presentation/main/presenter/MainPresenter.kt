package com.example.eugene_matsyuk.dagger_arch.presentation.main.presenter

import com.example.eugene_matsyuk.dagger_arch.presentation.main.view.MainView
import moxy.InjectViewState
import moxy.MvpPresenter

import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : MvpPresenter<MainView>()