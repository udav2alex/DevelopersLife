package ru.gressor.developerslife.ui

import android.app.Application
import ru.gressor.developerslife.di.AppComponent
import ru.gressor.developerslife.di.DaggerAppComponent
import ru.gressor.developerslife.di.comments.CommentsSubComponent
import ru.gressor.developerslife.di.module.AppModule
import ru.gressor.developerslife.di.pics.PicsSubComponent

class App: Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set
    var picsSubComponent: PicsSubComponent? = null
        private set
    var commentsSubComponent: CommentsSubComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this)).build()
    }

    fun initPicsSubComponent() = appComponent.picsSubComponent().also {
        picsSubComponent = it
    }

    fun releasePicsSubComponent() {
        picsSubComponent = null
    }

    fun initCommentsSubComponent() = picsSubComponent?.commentsSubComponent().also {
        commentsSubComponent = it
    }

    fun releaseCommentsSubComponent() {
        commentsSubComponent = null
    }
}