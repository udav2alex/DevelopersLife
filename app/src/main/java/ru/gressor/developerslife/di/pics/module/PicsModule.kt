package ru.gressor.developerslife.di.pics.module

import dagger.Module
import dagger.Provides
import ru.gressor.developerslife.di.pics.PicsScope
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.cache.PicsCache
import ru.gressor.developerslife.mvp.model.cache.room.RoomPicsCache
import ru.gressor.developerslife.mvp.model.db.DevLifeDB
import ru.gressor.developerslife.mvp.model.network.INetworkStatus
import ru.gressor.developerslife.mvp.model.repo.PicsRepo
import ru.gressor.developerslife.mvp.model.repo.retrofit.RetrofitPicsRepo

@Module
class PicsModule {

    @PicsScope
    @Provides
    fun getPicsRepo(
            iNetworkStatus: INetworkStatus,
            iDataSource: IDataSource,
            picsCache: PicsCache
    ): PicsRepo =
            RetrofitPicsRepo(iNetworkStatus, iDataSource, picsCache)

    @PicsScope
    @Provides
    fun getPicsCache(devLifeDB: DevLifeDB): PicsCache = RoomPicsCache(devLifeDB)
}