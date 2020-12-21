package ru.gressor.developerslife.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.entity.Comment
import ru.gressor.developerslife.mvp.model.entity.Pic

interface CommentsCache {
    fun loadComments(pic: Pic): Single<List<Comment>>
    fun saveComments(commentsList: List<Comment>): Completable
}