package ru.gressor.developerslife.mvp.model.entity

import java.util.*

data class Pic(
        val id: Int,
        val author: Author? = null,
        val date: Date? = null,
        val desc: String = "",
        val image: String = "",
        val prevImage: String = "",
        val votes: Int = 0
) {
}