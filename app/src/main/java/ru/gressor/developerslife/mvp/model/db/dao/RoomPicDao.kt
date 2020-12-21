package ru.gressor.developerslife.mvp.model.db.dao

import androidx.room.*
import ru.gressor.developerslife.mvp.model.db.entity.RoomPic
import ru.gressor.developerslife.mvp.model.entity.Pic

@Dao
interface RoomPicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomPic: RoomPic)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg roomPics: RoomPic)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomPicsList: List<RoomPic>)

    @Update
    fun update(roomPic: RoomPic)

    @Update
    fun update(vararg roomPics: RoomPic)

    @Update
    fun update(picsList: List<RoomPic>)

    @Delete
    fun delete(roomPic: RoomPic)

    @Delete
    fun delete(vararg roomPics: RoomPic)

    @Delete
    fun delete(roomPicsList: List<RoomPic>)

    @Query("SELECT * FROM RoomPic;")
    fun getAll(): List<RoomPic>

    @Query("SELECT * FROM RoomPic WHERE id = :id LIMIT 1;")
    fun getById(id: Int): RoomPic?
}