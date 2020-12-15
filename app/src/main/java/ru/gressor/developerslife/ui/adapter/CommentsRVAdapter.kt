package ru.gressor.developerslife.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.gressor.developerslife.databinding.ItemCommentBinding
import ru.gressor.developerslife.databinding.ItemPicBinding
import ru.gressor.developerslife.mvp.model.image.IImageLoader
import ru.gressor.developerslife.mvp.presenter.list.ICommentsListPresenter
import javax.inject.Inject

class CommentsRVAdapter(
        private val presenter: ICommentsListPresenter
) : RecyclerView.Adapter<ItemViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
            when (viewType) {
                0 -> PicViewHolder(
                        ItemPicBinding.inflate(
                                LayoutInflater.from(parent.context), parent, false),
                        imageLoader)
                else -> CommentViewHolder(
                        ItemCommentBinding.inflate(
                                LayoutInflater.from(parent.context), parent, false)
                )
            }

    override fun getItemViewType(position: Int) = presenter.getItemViewType(position)

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()
}