package ru.gressor.developerslife.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.entity.Comment
import ru.gressor.developerslife.mvp.model.entity.Pic

interface CommentsRepo {
    fun getComments(pic: Pic): Single<List<Comment>>
}