package ru.gressor.developerslife.di

import dagger.Component
import ru.gressor.developerslife.di.module.*
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
            CacheModule::class,
            CiceroneModule::class,
            DatabaseModule::class,
            ImageModule::class,
            RepoModule::class
        ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(picsPresenter: PicsPresenter)
    fun inject(picsRVAdapter: PicsRVAdapter)
    fun inject(commentsPresenter: CommentsPresenter)
    fun inject(commentsRVAdapter: CommentsRVAdapter)
}