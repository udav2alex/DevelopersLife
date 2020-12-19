package ru.gressor.developerslife.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gressor.developerslife.R
import ru.gressor.developerslife.di.pics.PicsSubComponent
import ru.gressor.developerslife.mvp.presenter.PicsPresenter
import ru.gressor.developerslife.mvp.view.PicsView
import ru.gressor.developerslife.ui.App
import ru.gressor.developerslife.ui.BackPressedListener
import ru.gressor.developerslife.ui.adapter.PicsRVAdapter

class PicsFragment : MvpAppCompatFragment(), PicsView, BackPressedListener {

    var picsSubComponent: PicsSubComponent? = App.instance.initPicsSubComponent()

    private val presenter by moxyPresenter {
        picsSubComponent = App.instance.initPicsSubComponent()
        PicsPresenter().apply {
            picsSubComponent?.inject(this)
        }
    }

    private lateinit var rvPicsList: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_pics, container, false)

        rvPicsList = view.findViewById(R.id.rv_pics_list)
        rvPicsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PicsRVAdapter(presenter.picsListPresenter).apply {
                picsSubComponent?.inject(this)
            }
        }

        return view
    }

    override fun showNoComments() {
        Toast.makeText(context, context?.getString(R.string.pic_has_no_comments), Toast.LENGTH_SHORT)
                .show()
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, throwable.message, Toast.LENGTH_LONG)
                .show()
    }

    override fun updateList() {
        rvPicsList.adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    override fun release() {
        picsSubComponent = null
        App.instance.releasePicsSubComponent()
    }

    companion object {
        fun newInstance() = PicsFragment()
    }
}
