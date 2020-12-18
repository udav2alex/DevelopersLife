package ru.gressor.developerslife.di.module

import dagger.Module
import dagger.Provides
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.cache.CommentsCache
import ru.gressor.developerslife.mvp.model.cache.PicsCache
import ru.gressor.developerslife.mvp.model.network.INetworkStatus
import ru.gressor.developerslife.mvp.model.repo.CommentsRepo
import ru.gressor.developerslife.mvp.model.repo.PicsRepo
import ru.gressor.developerslife.mvp.model.repo.retrofit.RetrofitCommentsRepo
import ru.gressor.developerslife.mvp.model.repo.retrofit.RetrofitPicsRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun getPicsRepo(
            iNetworkStatus: INetworkStatus,
            iDataSource: IDataSource,
            picsCache: PicsCache
    ): PicsRepo =
            RetrofitPicsRepo(iNetworkStatus, iDataSource, picsCache)

    @Singleton
    @Provides
    fun getCommentsRepo(
            iNetworkStatus: INetworkStatus,
            iDataSource: IDataSource,
            commentsCache: CommentsCache
    ): CommentsRepo =
            RetrofitCommentsRepo(iNetworkStatus, iDataSource, commentsCache)
}