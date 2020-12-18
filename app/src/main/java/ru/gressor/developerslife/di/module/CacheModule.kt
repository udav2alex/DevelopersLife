package ru.gressor.developerslife.di.module

import dagger.Module
import dagger.Provides
import ru.gressor.developerslife.mvp.model.cache.CommentsCache
import ru.gressor.developerslife.mvp.model.cache.PicsCache
import ru.gressor.developerslife.mvp.model.cache.room.RoomCommentsCache
import ru.gressor.developerslife.mvp.model.cache.room.RoomPicsCache
import ru.gressor.developerslife.mvp.model.db.DevLifeDB
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun getPicsCache(devLifeDB: DevLifeDB): PicsCache = RoomPicsCache(devLifeDB)

    @Singleton
    @Provides
    fun getCommentsCache(devLifeDB: DevLifeDB): CommentsCache = RoomCommentsCache(devLifeDB)
}