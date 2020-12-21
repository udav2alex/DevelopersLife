package ru.gressor.developerslife.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.gressor.developerslife.mvp.model.db.DevLifeDB
import ru.gressor.developerslife.ui.App
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(app: App): DevLifeDB =
        Room.databaseBuilder(app, DevLifeDB::class.java, DevLifeDB.DB_NAME).build()
}