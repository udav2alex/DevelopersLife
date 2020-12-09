package ru.gressor.developerslife.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.gressor.developerslife.mvp.model.api.entity.CommentsPage
import ru.gressor.developerslife.mvp.model.api.entity.PicsPage

interface IDataSource {

    @GET("/latest/{page}?json=true")
    fun getPics(
            @Path("page") page: Int,
            @Query("pageSize") size: Int
    ): Single<PicsPage>

    @GET("/comments/entry/{id}?json=true")
    fun getComments(
            @Path("id") picId: Int
    ): Single<CommentsPage>

    // TODO delete!
    @GET("/comments/entry/17068?json=true")
    fun getMyComments(): Single<CommentsPage>
}