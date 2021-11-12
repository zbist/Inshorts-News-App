package com.zbistapp.inshortsnews

import android.app.Application
import com.zbistapp.inshortsnews.di.AppComponent
import com.zbistapp.inshortsnews.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy { DaggerAppComponent.builder().build() }

    companion object {
        lateinit var INSTANCE: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}