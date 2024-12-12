package com.example.eugene_matsyuk.dagger_arch.di.app

import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication
import com.example.eugene_matsyuk.dagger_arch.presentation.main.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
abstract class AppComponent {
    abstract fun inject(daggerArchApplication: DaggerArchApplication)
    abstract fun inject(mainActivity: MainActivity)
    abstract fun mainScreenComponent(): MainScreenComponent

    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return requireNotNull(instance) {
                "AppComponent is not initialized yet. Call init first."
            }
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }
    }
}