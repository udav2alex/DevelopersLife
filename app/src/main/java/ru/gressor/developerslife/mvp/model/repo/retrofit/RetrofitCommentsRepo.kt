package ru.gressor.developerslife.mvp.model.repo.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.api.entity.ApiComment
import ru.gressor.developerslife.mvp.model.cache.CommentsCache
import ru.gressor.developerslife.mvp.model.entity.Comment
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.mvp.model.network.INetworkStatus
import ru.gressor.developerslife.mvp.model.repo.CommentsRepo

class RetrofitCommentsRepo(
        private val networkStatus: INetworkStatus,
        private val iDataSource: IDataSource,
        private val commentsCache: CommentsCache
) : CommentsRepo {

    override fun getComments(pic: Pic): Single<List<Comment>> =
            networkStatus.isOnlineSingle()
                    .subscribeOn(Schedulers.io())
                    .flatMap { isOnline ->
                        if(isOnline) {
                            iDataSource.getComments(pic.id)
                                    .map { commentsPage ->
                                        commentsPage.comments.map {
                                            api2DomainComment(it, pic)
                                        }
                                    }
                                    .doOnSuccess {
                                        commentsCache.saveComments(it)
                                    }
                        } else {
                            commentsCache.loadComments(pic)
                        }
                    }

    private fun api2DomainComment(apiComment: ApiComment, pic: Pic) = Comment(
            apiComment.id,
            apiComment.date,
            apiComment.text,
            apiComment.voteCount,
            pic,
            apiComment.authorName
    )
}