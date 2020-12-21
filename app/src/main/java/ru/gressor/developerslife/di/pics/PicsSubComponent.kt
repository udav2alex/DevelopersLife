package ru.gressor.developerslife.di.pics

import dagger.Subcomponent
import ru.gressor.developerslife.di.comments.CommentsSubComponent
import ru.gressor.developerslife.di.pics.module.PicsModule
import ru.gressor.developerslife.mvp.presenter.PicsPresenter
import ru.gressor.developerslife.ui.adapter.PicsRVAdapter

@PicsScope
@Subcomponent(
        modules = [
            PicsModule::class
        ]
)
interface PicsSubComponent {
    fun commentsSubComponent(): CommentsSubComponent

    fun inject(picsPresenter: PicsPresenter)
    fun inject(picsRVAdapter: PicsRVAdapter)
}