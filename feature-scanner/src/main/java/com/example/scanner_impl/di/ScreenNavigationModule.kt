package com.example.scanner_impl.di

import com.example.core.di.general.PerFeature
import dagger.Module
import dagger.Provides
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

@Module
internal class ScreenNavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @PerFeature
    @Provides
    fun provideRouter(): Router {
        return cicerone.router
    }

    @PerFeature
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

}