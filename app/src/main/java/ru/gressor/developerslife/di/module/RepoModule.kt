package ru.gressor.developerslife.di.module

import dagger.Module
import dagger.Provides
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.repo.CommentsRepo
import ru.gressor.developerslife.mvp.model.repo.PicsRepo
import ru.gressor.developerslife.mvp.model.repo.retrofit.RetrofitCommentsRepo
import ru.gressor.developerslife.mvp.model.repo.retrofit.RetrofitPicsRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun getPicsRepo(iDataSource: IDataSource): PicsRepo =
            RetrofitPicsRepo(iDataSource)

    @Singleton
    @Provides
    fun getCommentsRepo(iDataSource: IDataSource): CommentsRepo =
            RetrofitCommentsRepo(iDataSource)
}