package ru.gressor.developerslife.di.comments.module

import dagger.Module
import dagger.Provides
import ru.gressor.developerslife.di.comments.CommentsScope
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.cache.CommentsCache
import ru.gressor.developerslife.mvp.model.cache.room.RoomCommentsCache
import ru.gressor.developerslife.mvp.model.db.DevLifeDB
import ru.gressor.developerslife.mvp.model.network.INetworkStatus
import ru.gressor.developerslife.mvp.model.repo.CommentsRepo
import ru.gressor.developerslife.mvp.model.repo.retrofit.RetrofitCommentsRepo

@Module
class CommentsModule {

    @CommentsScope
    @Provides
    fun getCommentsRepo(
            iNetworkStatus: INetworkStatus,
            iDataSource: IDataSource,
            commentsCache: CommentsCache
    ): CommentsRepo =
            RetrofitCommentsRepo(iNetworkStatus, iDataSource, commentsCache)

    @CommentsScope
    @Provides
    fun getCommentsCache(devLifeDB: DevLifeDB): CommentsCache = RoomCommentsCache(devLifeDB)
}