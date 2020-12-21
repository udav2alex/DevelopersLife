package ru.gressor.developerslife.mvp.model.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
        foreignKeys = [ForeignKey(
                entity = RoomPic::class,
                parentColumns = ["id"],
                childColumns = ["picId"],
                onDelete = ForeignKey.CASCADE
        )],
        indices = [
                Index("picId")
        ]
)
class RoomComment(
        @PrimaryKey
        var id: Int,
        var date: String = "",
        var text: String = "",
        var voteCount: Int = 0,
        var picId: Int,
        var author: String = ""
)