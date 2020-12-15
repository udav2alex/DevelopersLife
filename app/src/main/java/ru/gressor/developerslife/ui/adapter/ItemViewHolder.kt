package ru.gressor.developerslife.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import ru.gressor.developerslife.mvp.view.list.IListView

open class ItemViewHolder(
        viewBinding: ViewBinding
) : RecyclerView.ViewHolder(viewBinding.root), IListView {

    override var pos: Int = -1

    val context: Context = viewBinding.root.context
}