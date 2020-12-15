package ru.gressor.developerslife.mvp.model.api.entity

import com.google.gson.annotations.Expose

data class ApiComment(
        @Expose val id: Int = 0,
        @Expose val text: String = "",
        @Expose val date: String = "",

        @Expose val authorId: Int = 0,
        @Expose val authorName: String = "",

        @Expose val voteCount: Int = 0,

        @Expose val entryId: Int = 0,
        @Expose val parentId: Int? = null,

        @Expose val deleted: Boolean = false
) {
}