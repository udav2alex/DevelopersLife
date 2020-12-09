package ru.gressor.developerslife.di

import dagger.Component
import ru.gressor.developerslife.di.module.AppModule
import ru.gressor.developerslife.di.module.CiceroneModule
import ru.gressor.developerslife.mvp.presenter.MainPresenter
import ru.gressor.developerslife.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            CiceroneModule::class
        ]
)
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)
    fun inject(mainActivity: MainActivity)
}