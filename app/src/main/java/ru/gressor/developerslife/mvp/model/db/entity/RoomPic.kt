package ru.gressor.developerslife.mvp.model.db.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
class RoomPic(
        @PrimaryKey
        var id: Int,
        var author: String = "",
        var date: String = "",
        var description: String = "",
        var imageSrc: String = "",
        var previewSrc: String = "",
        var votesCount: Int = 0,
        var commentsCount: Int = 0
)