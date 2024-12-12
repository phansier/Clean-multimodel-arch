package com.example.eugene_matsyuk.dagger_arch

import android.app.Application
import android.content.Context
import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent
import com.example.eugene_matsyuk.dagger_arch.di.app.DaggerAppComponent

class DaggerArchApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
                DaggerAppComponent.builder()
                        .build()
        )
        AppComponent.get().inject(this)
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}