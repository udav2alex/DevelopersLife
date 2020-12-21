package ru.gressor.developerslife.mvp.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.mvp.model.repo.PicsRepo
import ru.gressor.developerslife.mvp.presenter.list.IPicsListPresenter
import ru.gressor.developerslife.mvp.view.PicsView
import ru.gressor.developerslife.mvp.view.list.IPicView
import ru.gressor.developerslife.navigation.Screens
import javax.inject.Inject

class PicsPresenter : MvpPresenter<PicsView>() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var picsRepo: PicsRepo
    @Inject
    lateinit var scheduler: Scheduler

    val picsListPresenter = PicsListPresenter()

    class PicsListPresenter : IPicsListPresenter {
        override var itemClickListener: ((IPicView) -> Unit)? = null
        val pics = mutableListOf<Pic>()

        override fun getCount(): Int = pics.size

        override fun bindView(view: IPicView) {
            val position = view.pos
            val pic = pics[position]

            view.setAuthor(pic.author)
            view.setDate(pic.date)
            view.setDescription(pic.description)
            view.setImageSrc(pic.imageSrc)
            view.setPreviewSrc(pic.previewSrc)
            view.setVotesCount(pic.votesCount)
            view.setCommentsCount(pic.commentsCount)
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadPicsData()

        picsListPresenter.itemClickListener = {
            val pic = picsListPresenter.pics[it.pos]
            if (pic.commentsCount != 0) {
                router.navigateTo(Screens.commentsList(pic))
            } else {
                viewState.showNoComments()
            }
        }
    }

    private fun loadPicsData() {
        picsRepo.getPics()
                .observeOn(scheduler)
                .subscribe(
                        { picsList ->
                            picsListPresenter.pics.clear()
                            picsListPresenter.pics.addAll(picsList)
                            viewState.updateList()
                        },
                        { throwable ->
                            viewState.showError(throwable)
                        }
                )
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.release()
    }
}