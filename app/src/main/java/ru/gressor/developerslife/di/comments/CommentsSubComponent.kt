package ru.gressor.developerslife.di.comments

import dagger.Subcomponent
import ru.gressor.developerslife.di.comments.module.CommentsModule
import ru.gressor.developerslife.mvp.presenter.CommentsPresenter
import ru.gressor.developerslife.ui.adapter.CommentsRVAdapter

@CommentsScope
@Subcomponent(
        modules = [
            CommentsModule::class
        ]
)
interface CommentsSubComponent {
    fun inject(commentsPresenter: CommentsPresenter)
    fun inject(commentsRVAdapter: CommentsRVAdapter)
}