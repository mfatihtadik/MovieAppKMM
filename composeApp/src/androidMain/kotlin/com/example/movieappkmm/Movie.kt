package com.example.movieappkmm

import android.app.Application
import com.example.movieappkmm.di.appModule
import com.example.movieappkmm.di.getSharedModules
import org.koin.core.context.GlobalContext.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}