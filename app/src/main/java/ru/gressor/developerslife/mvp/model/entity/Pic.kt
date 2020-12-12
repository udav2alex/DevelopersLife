package ru.gressor.developerslife.mvp.model.entity

data class Pic(
        val id: Int,
        val author: String = "",
        val date: String = "",
        val description: String = "",
        val imageSrc: String = "",
        val previewSrc: String = "",
        val votesCount: Int = 0,
        val commentsCount: Int = 0
) {
}