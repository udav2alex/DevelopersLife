package ru.gressor.developerslife.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.entity.Pic

interface PicsCache {
    fun loadPics(): Single<List<Pic>>
    fun savePics(picsList: List<Pic>): Completable
}