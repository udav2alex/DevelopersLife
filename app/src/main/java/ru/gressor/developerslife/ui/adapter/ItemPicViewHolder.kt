package ru.gressor.developerslife.ui.adapter

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.gressor.developerslife.R
import ru.gressor.developerslife.databinding.ItemPicBinding
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.mvp.model.image.IImageLoader
import ru.gressor.developerslife.mvp.view.list.IPicView

class ItemPicViewHolder(
        private val binding: ItemPicBinding,
        private val imageLoader: IImageLoader<ImageView>
) : RecyclerView.ViewHolder(binding.root), IPicView {

    override var pos: Int = -1
    private val context: Context = binding.root.context

    override fun setAuthor(author: String) {
        binding.tvPicAuthor.text = author
    }

    override fun setDate(date: String) {
        binding.tvPicDate.text = date
    }

    override fun setDescription(desc: String) {
        binding.tvPicDesc.text = desc
    }

    override fun setImageSrc(src: String) {
        imageLoader.loadImage(src, binding.ivPic)
    }

    override fun setPreviewSrc(src: String) {
        // TODO: have I?
    }

    override fun setVotesCount(count: Int) {
        binding.tvPicRating.text = context.getString(R.string.rating_pattern, count)
    }

    override fun setCommentsCount(count: Int) {
        binding.tvPicComments.text = context.getString(R.string.comments_quantity, count)
    }
}