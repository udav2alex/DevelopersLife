package ru.gressor.developerslife.mvp.model.entity

data class Comment(
        val id: Int,
        val date: String = "",
        val text: String = "",
        val voteCount: Int = 0,

        val pic: Pic,
        val author: String = ""
) {
}