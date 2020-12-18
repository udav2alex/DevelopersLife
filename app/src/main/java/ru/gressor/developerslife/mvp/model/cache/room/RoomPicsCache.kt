package ru.gressor.developerslife.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.gressor.developerslife.mvp.model.cache.PicsCache
import ru.gressor.developerslife.mvp.model.db.DevLifeDB
import ru.gressor.developerslife.mvp.model.db.entity.RoomPic
import ru.gressor.developerslife.mvp.model.entity.Pic

class RoomPicsCache(
        private val db: DevLifeDB
) : PicsCache {

    override fun loadPics(): Single<List<Pic>> = Single.fromCallable {
        db.roomPicDao.getAll().map { room2DomainPic(it) }
    }

    override fun savePics(picsList: List<Pic>): Completable = Completable.fromAction {
        db.roomPicDao.insert(picsList.map { domain2RoomPic(it) })
    }

    private fun domain2RoomPic(pic: Pic) = RoomPic(
            pic.id,
            pic.author,
            pic.date,
            pic.description,
            pic.imageSrc,
            pic.previewSrc,
            pic.votesCount,
            pic.commentsCount
    )

    private fun room2DomainPic(roomPic: RoomPic) = Pic(
            roomPic.id,
            roomPic.author,
            roomPic.date,
            roomPic.description,
            roomPic.imageSrc,
            roomPic.previewSrc,
            roomPic.votesCount,
            roomPic.commentsCount
    )
}