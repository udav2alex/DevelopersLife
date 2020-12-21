package ru.gressor.developerslife.mvp.model.db.dao

import androidx.room.*
import ru.gressor.developerslife.mvp.model.db.entity.RoomComment

@Dao
interface RoomCommentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomComment: RoomComment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg roomComments: RoomComment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomCommentsList: List<RoomComment>)

    @Update
    fun update(roomComment: RoomComment)

    @Update
    fun update(vararg roomComments: RoomComment)

    @Update
    fun update(roomCommentsList: List<RoomComment>)

    @Delete
    fun delete(roomComment: RoomComment)

    @Delete
    fun delete(vararg roomComments: RoomComment)

    @Delete
    fun delete(roomCommentsList: List<RoomComment>)

    @Query("SELECT * FROM RoomComment;")
    fun getAll(): List<RoomComment>

    @Query("SELECT * FROM RoomComment WHERE picId = :picId;")
    fun getByPicId(picId: Int): List<RoomComment>

    @Query("SELECT * FROM RoomComment WHERE id = :id LIMIT 1;")
    fun getById(id: Int): RoomComment?
}