package ru.gressor.developerslife.mvp.model.api.entity

import com.google.gson.annotations.Expose

data class PicsPage(
        @Expose val result: Set<RetrofitPic>
) {
}