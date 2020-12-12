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
import ru.gressor.developerslife.mvp.presenter.PicsPresenter
import ru.gressor.developerslife.mvp.view.PicsView
import ru.gressor.developerslife.ui.App
import ru.gressor.developerslife.ui.BackPressedListener
import ru.gressor.developerslife.ui.adapter.PicsRVAdapter

class PicsFragment : MvpAppCompatFragment(), PicsView, BackPressedListener {
    companion object {
        fun newInstance() = PicsFragment()
    }

    private val presenter by moxyPresenter {
        PicsPresenter().apply { App.instance.appComponent.inject(this) }
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
            layoutManager = LinearLayoutManager(activity)
            adapter = PicsRVAdapter(presenter.picsListPresenter).apply {
                App.instance.appComponent.inject(this)
            }
        }

        return view
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun updateList() {
        rvPicsList.adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}