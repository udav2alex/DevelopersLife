package ru.gressor.developerslife.mvp.model.api.entity

import com.google.gson.annotations.Expose

data class CommentsPage(
        @Expose val comments: Set<RetrofitComment>
) {
}