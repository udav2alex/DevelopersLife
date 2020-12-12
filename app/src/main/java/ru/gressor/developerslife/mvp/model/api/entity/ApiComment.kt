package ru.gressor.developerslife.mvp.model.api.entity

import com.google.gson.annotations.Expose

data class ApiComment(
        @Expose private val id: Int = 0,
        @Expose private val text: String = "",
        @Expose private val date: String = "",

        @Expose private val authorId: Int = 0,
        @Expose private val authorName: String = "",

        @Expose private val voteCount: Int = 0,

        @Expose private val entryId: Int = 0,
        @Expose private val parentId: Int? = null,

        @Expose private val deleted: Boolean = false
) {
}