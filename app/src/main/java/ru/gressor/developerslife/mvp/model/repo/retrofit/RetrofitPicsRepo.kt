package ru.gressor.developerslife.mvp.model.repo.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.gressor.developerslife.mvp.model.repo.PicsRepo
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.api.entity.ApiPic
import ru.gressor.developerslife.mvp.model.cache.PicsCache
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.mvp.model.network.INetworkStatus

class RetrofitPicsRepo(
        private val networkStatus: INetworkStatus,
        private val iDataSource: IDataSource,
        private val picsCache: PicsCache
) : PicsRepo {
    // TODO deal with it!
    private val pageNumber = 0
    private val pageSize = 5

    override fun getPics(): Single<List<Pic>> =
            networkStatus.isOnlineSingle()
                    .subscribeOn(Schedulers.io())
                    .flatMap { isOnline ->
                        if (isOnline) {
                            iDataSource
                                    .getPics(pageNumber, pageSize)
                                    .map { picsPage ->
                                        picsPage.result.map {
                                            api2DomainPic(it)
                                        }
                                    }
                                    .doOnSuccess { picsList ->
                                        picsCache.savePics(picsList)
                                    }
                        } else {
                            picsCache.loadPics()
                        }
                    }

    private fun api2DomainPic(apiPic: ApiPic) = Pic(
            apiPic.id,
            apiPic.author,
            apiPic.date,
            apiPic.description,
            apiPic.gifURL,
            apiPic.previewURL,
            apiPic.votes,
            apiPic.commentsCount
    )
}