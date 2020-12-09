package ru.gressor.developerslife.mvp.model.entity

data class Author(
        val id: Int,
        val nickname: String,
        val rating: Int = 0,
        val entriesCount: Int = 0,
        val commentsCount: Int = 0
) {
}