package ru.gressor.developerslife.mvp.model.repo.retrofit

import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.entity.Comment
import ru.gressor.developerslife.mvp.model.repo.CommentsRepo
import ru.gressor.developerslife.mvp.model.repo.PicsRepo

class RetrofitCommentsRepo(
        private val iDataSource: IDataSource
) : CommentsRepo {

    override fun getComments(pic: PicsRepo): Single<List<Comment>> {
        TODO("Not yet implemented")
    }
}