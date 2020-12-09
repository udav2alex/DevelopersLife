package ru.gressor.developerslife.ui

import android.app.Application
import ru.gressor.developerslife.di.AppComponent
import ru.gressor.developerslife.di.DaggerAppComponent
import ru.gressor.developerslife.di.module.AppModule

class App: Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this)).build()
    }
}