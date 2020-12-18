package ru.gressor.developerslife.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.gressor.developerslife.mvp.model.api.entity.CommentsPage
import ru.gressor.developerslife.mvp.model.api.entity.PicsPage

interface IDataSource {

    @GET("/latest/{pageNumber}?json=true")
    fun getPics(
            @Path("pageNumber") pageNumber: Int,
            @Query("pageSize") pageSize: Int
    ): Single<PicsPage>

    @GET("/comments/entry/{picId}?json=true")
    fun getComments(
            @Path("picId") picId: Int
    ): Single<CommentsPage>
}