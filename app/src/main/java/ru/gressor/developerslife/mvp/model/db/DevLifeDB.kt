package ru.gressor.developerslife.mvp.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.gressor.developerslife.mvp.model.db.dao.RoomCommentDao
import ru.gressor.developerslife.mvp.model.db.dao.RoomPicDao
import ru.gressor.developerslife.mvp.model.db.entity.RoomComment
import ru.gressor.developerslife.mvp.model.db.entity.RoomPic

@Database(
        entities = [RoomPic::class, RoomComment::class],
        exportSchema = false,
        version = 1)
abstract class DevLifeDB: RoomDatabase() {
    abstract val roomPicDao: RoomPicDao
    abstract val roomCommentDao: RoomCommentDao

    companion object {
        const val DB_NAME = "developerslife.db"
    }
}