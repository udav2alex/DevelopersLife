package ru.gressor.developerslife.mvp.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.gressor.developerslife.mvp.model.entity.Comment
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.mvp.model.repo.CommentsRepo
import ru.gressor.developerslife.mvp.presenter.list.ICommentsListPresenter
import ru.gressor.developerslife.mvp.view.CommentsView
import ru.gressor.developerslife.mvp.view.list.ICommentView
import ru.gressor.developerslife.mvp.view.list.IListView
import ru.gressor.developerslife.mvp.view.list.IPicView
import javax.inject.Inject

class CommentsPresenter(
        private val pic: Pic
) : MvpPresenter<CommentsView>() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var commentsRepo: CommentsRepo
    @Inject
    lateinit var scheduler: Scheduler

    val commentsListPresenter = CommentsListPresenter()

    inner class CommentsListPresenter : ICommentsListPresenter {
        override var itemClickListener: ((IListView) -> Unit)? = null
        val comments = mutableListOf<Comment>()

        override fun getCount() = comments.size + 1

        override fun getItemViewType(position: Int) = if (position == 0) 0 else 1

        override fun bindView(view: IListView) {
            when(view.pos) {
                0 -> bindHeaderView(view as IPicView)
                else -> bindHeaderView(view as ICommentView)
            }
        }

        private fun bindHeaderView(view: IPicView) {
            view.setAuthor(pic.author)
            view.setDate(pic.date)
            view.setDescription(pic.description)
            view.setImageSrc(pic.imageSrc)
            view.setPreviewSrc(pic.previewSrc)
            view.setVotesCount(pic.votesCount)
            view.setCommentsCount(pic.commentsCount)
        }

        private fun bindHeaderView(view: ICommentView) {
            val comment = comments[view.pos - 1]

            view.setAuthor(comment.author)
            view.setDate(comment.date)
            view.setText(comment.text)
            view.setVoteCount(comment.voteCount)
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCommentsData()
    }

    private fun loadCommentsData() {
        commentsRepo.getComments(pic)
                .observeOn(scheduler)
                .subscribe(
                        { commentsList ->
                            commentsListPresenter.comments.clear()
                            commentsListPresenter.comments.addAll(commentsList)
                            viewState.updateList()
                        },
                        { throwable ->
                            viewState.showError(throwable)
                        })
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