package ru.gressor.developerslife.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.entity.Comment

interface CommentsRepo {
    fun getComments(pic: PicsRepo): Single<List<Comment>>
}