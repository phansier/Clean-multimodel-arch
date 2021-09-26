package com.example.eugene_matsyuk.dagger_arch

import android.app.Application
import android.content.Context
import com.example.eugene_matsyuk.dagger_arch.di.DiConstants
import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent
import com.example.eugene_matsyuk.dagger_arch.di.app.DaggerAppComponent
import com.example.eugene_matsyuk.dagger_arch.routing.GlobalNavigator
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Named

class DaggerArchApplication : Application() {
    @Inject
    @field:Named(DiConstants.GLOBAL)
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var globalNavigator: GlobalNavigator

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
                DaggerAppComponent.builder()
                        .build()
        )
        AppComponent.get().inject(this)
        navigatorHolder.setNavigator(globalNavigator)
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}