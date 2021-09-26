package com.example.antitheft_impl.di

import com.example.core.di.general.PerFeature
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
internal class AntitheftNavigationModule {
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