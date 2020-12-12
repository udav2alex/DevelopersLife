package ru.gressor.developerslife.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.entity.Pic

interface PicsRepo {
    fun getPics(): Single<List<Pic>>
}