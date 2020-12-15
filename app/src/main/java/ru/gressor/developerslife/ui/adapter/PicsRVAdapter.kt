package ru.gressor.developerslife.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.gressor.developerslife.databinding.ItemPicBinding
import ru.gressor.developerslife.mvp.model.image.IImageLoader
import ru.gressor.developerslife.mvp.presenter.PicsPresenter
import ru.gressor.developerslife.mvp.presenter.list.IPicsListPresenter
import javax.inject.Inject

class PicsRVAdapter(
        private val presenter: IPicsListPresenter
) : RecyclerView.Adapter<PicViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            PicViewHolder(
                    ItemPicBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false),
                    imageLoader
            )

    override fun onBindViewHolder(holder: PicViewHolder, position: Int) {
        holder.pos = position
        holder.itemView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun getItemCount(): Int = presenter.getCount()
}
