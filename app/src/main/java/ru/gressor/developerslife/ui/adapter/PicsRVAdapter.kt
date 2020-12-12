package ru.gressor.developerslife.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.gressor.developerslife.R
import ru.gressor.developerslife.databinding.ItemPicBinding
import ru.gressor.developerslife.mvp.model.image.IImageLoader
import ru.gressor.developerslife.mvp.presenter.PicsPresenter
import ru.gressor.developerslife.ui.image.GlideImageLoader
import javax.inject.Inject

class PicsRVAdapter(
        private val presenter: PicsPresenter.PicsListPresenter
) : RecyclerView.Adapter<ItemPicViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ItemPicViewHolder(
                    ItemPicBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false),
                    imageLoader
            )

    override fun onBindViewHolder(holder: ItemPicViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }

    override fun getItemCount(): Int = presenter.getCount()
}
