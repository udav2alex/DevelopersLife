package ru.gressor.developerslife.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gressor.developerslife.R
import ru.gressor.developerslife.di.pics.PicsSubComponent
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.mvp.presenter.CommentsPresenter
import ru.gressor.developerslife.mvp.view.CommentsView
import ru.gressor.developerslife.ui.App
import ru.gressor.developerslife.ui.BackPressedListener
import ru.gressor.developerslife.ui.adapter.CommentsRVAdapter

class CommentsFragment: MvpAppCompatFragment(), CommentsView, BackPressedListener {

    private var commentsSubComponent = App.instance.initCommentsSubComponent()

    private val presenter by moxyPresenter {
        val pic = arguments?.getParcelable<Pic>(ARGUMENT_TAG_PIC) as Pic
        CommentsPresenter(pic).apply {
            commentsSubComponent?.inject(this)
        }
    }

    private lateinit var rvCommentsList: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comments, container, false)

        rvCommentsList = view.findViewById(R.id.rv_comment_list)
        rvCommentsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CommentsRVAdapter(presenter.commentsListPresenter).apply {
                commentsSubComponent?.inject(this)
            }
        }

        return view
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun updateList() {
        rvCommentsList.adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    override fun release() {
        commentsSubComponent = null
        App.instance.releaseCommentsSubComponent()
    }

    companion object {
        private const val ARGUMENT_TAG_PIC = "CommentsFragment.ARGUMENT_TAG_PIC"

        fun newInstance(pic: Pic) = CommentsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARGUMENT_TAG_PIC, pic)
            }
        }
    }
}