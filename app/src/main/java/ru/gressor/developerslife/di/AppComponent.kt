package ru.gressor.developerslife.di

import dagger.Component
import ru.gressor.developerslife.di.comments.CommentsSubComponent
import ru.gressor.developerslife.di.module.*
import ru.gressor.developerslife.di.pics.PicsSubComponent
import ru.gressor.developerslife.mvp.presenter.CommentsPresenter
import ru.gressor.developerslife.mvp.presenter.MainPresenter
import ru.gressor.developerslife.mvp.presenter.PicsPresenter
import ru.gressor.developerslife.ui.MainActivity
import ru.gressor.developerslife.ui.adapter.CommentsRVAdapter
import ru.gressor.developerslife.ui.adapter.PicsRVAdapter
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            ApiModule::class,
            AppModule::class,
            CiceroneModule::class,
            DatabaseModule::class,
            ImageModule::class
        ]
)
interface AppComponent {
    fun picsSubComponent(): PicsSubComponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}