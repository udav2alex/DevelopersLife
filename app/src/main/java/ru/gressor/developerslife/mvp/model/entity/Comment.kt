package ru.gressor.developerslife.mvp.model.entity

import java.util.*

data class Comment(
        val id: Int,
        val date: Date? = null,
        val text: String = "",
        val voteCount: Int = 0,

        val pic: Pic,
        val author: Author? = null
) {
}