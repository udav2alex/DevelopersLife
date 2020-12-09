package ru.gressor.developerslife.mvp.model.api.entity

import com.google.gson.annotations.Expose

data class RetrofitPic(
        @Expose private val id: Int = 0,
        @Expose private val author: String = "",
        @Expose private val date: String = "",

        @Expose private val description: String = "",

        @Expose private val gifURL: String = "",
        @Expose private val previewURL: String = "",
        @Expose private val videoURL: String = "",

        @Expose private val votes: Int = 0,

        @Expose private val type: String = "",
        @Expose private val width: String = "",
        @Expose private val height: String = "",

        @Expose private val commentsCount: Int = 0
){
}