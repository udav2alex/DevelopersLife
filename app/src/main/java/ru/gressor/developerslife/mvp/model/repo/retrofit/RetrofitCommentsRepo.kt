package ru.gressor.developerslife.mvp.model.repo.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.entity.Comment
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.mvp.model.repo.CommentsRepo

class RetrofitCommentsRepo(
        private val iDataSource: IDataSource
) : CommentsRepo {

    override fun getComments(pic: Pic): Single<List<Comment>> {
        return iDataSource.getComments(pic.id).subscribeOn(Schedulers.io())
                .map { commentsPage ->
                    commentsPage.comments.map {
                        Comment(
                                it.id,
                                it.date,
                                it.text,
                                it.voteCount,
                                pic,
                                it.authorName
                        )
                    }
                }
    }
}