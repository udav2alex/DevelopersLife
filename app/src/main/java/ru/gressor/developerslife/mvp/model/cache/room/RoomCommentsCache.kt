package ru.gressor.developerslife.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.cache.CommentsCache
import ru.gressor.developerslife.mvp.model.db.DevLifeDB
import ru.gressor.developerslife.mvp.model.db.entity.RoomComment
import ru.gressor.developerslife.mvp.model.entity.Comment
import ru.gressor.developerslife.mvp.model.entity.Pic

class RoomCommentsCache(
        private val db: DevLifeDB
): CommentsCache {
    override fun loadComments(pic: Pic): Single<List<Comment>> = Single.fromCallable {
        db.roomCommentDao.getByPicId(pic.id).map { db2DomainComment(it, pic) }
    }

    override fun saveComments(commentsList: List<Comment>): Completable = Completable.fromAction {
        db.roomCommentDao.insert(commentsList.map { domain2DbComment(it) })
    }

    private fun domain2DbComment(comment: Comment) = RoomComment(
            comment.id,
            comment.date,
            comment.text,
            comment.voteCount,
            comment.pic.id,
            comment.author
    )

    private fun db2DomainComment(roomComment: RoomComment, pic: Pic) = Comment(
            roomComment.id,
            roomComment.date,
            roomComment.text,
            roomComment.voteCount,
            pic,
            roomComment.author
    )
}