package ru.gressor.developerslife.mvp.model.api.entity

import com.google.gson.annotations.Expose

data class ApiPic(
        @Expose val id: Int = 0,
        @Expose val author: String = "",
        @Expose val date: String = "",

        @Expose val description: String = "",

        @Expose val gifURL: String = "",
        @Expose val previewURL: String = "",
        @Expose val videoURL: String = "",

        @Expose val votes: Int = 0,

        @Expose val type: String = "",
        @Expose val width: String = "",
        @Expose val height: String = "",

        @Expose val commentsCount: Int = 0
){
}