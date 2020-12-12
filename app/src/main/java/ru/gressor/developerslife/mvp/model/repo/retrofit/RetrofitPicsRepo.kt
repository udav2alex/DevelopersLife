package ru.gressor.developerslife.mvp.model.repo.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.gressor.developerslife.mvp.model.repo.PicsRepo
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.entity.Pic
import java.util.*

class RetrofitPicsRepo(
        private val iDataSource: IDataSource
) : PicsRepo {

    override fun getPics(): Single<List<Pic>> {
        val pageNumber = 0
        val pageSize = 5

        return iDataSource
                .getPics(pageNumber, pageSize)
                .subscribeOn(Schedulers.io())
                .map { picsPage ->
                    picsPage?.result?.map {
                        Pic(
                                it.id,
                                it.author,
                                it.date,
                                it.description,
                                it.gifURL,
                                it.previewURL,
                                it.votes,
                                it.commentsCount
                        )
                    } ?: Collections.emptyList()
                }
    }
}