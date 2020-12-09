package ru.gressor.developerslife.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CiceroneModule {
    var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    @Singleton
    @Provides
    fun getRouter() = cicerone.router

    @Singleton
    @Provides
    fun getNavigatorHolder() = cicerone.getNavigatorHolder()
}