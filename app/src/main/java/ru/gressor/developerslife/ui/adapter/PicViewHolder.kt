package ru.gressor.developerslife.ui.adapter

import android.widget.ImageView
import ru.gressor.developerslife.R
import ru.gressor.developerslife.databinding.ItemPicBinding
import ru.gressor.developerslife.mvp.model.image.IImageLoader
import ru.gressor.developerslife.mvp.view.list.IPicView

class PicViewHolder(
        private val viewBinding: ItemPicBinding,
        private val imageLoader: IImageLoader<ImageView>
) : ItemViewHolder(viewBinding), IPicView {

    override fun setAuthor(author: String) {
        viewBinding.tvPicAuthor.text = author
    }

    override fun setDate(date: String) {
        viewBinding.tvPicDate.text = date
    }

    override fun setDescription(desc: String) {
        viewBinding.tvPicDesc.text = desc
    }

    override fun setImageSrc(src: String) {
        imageLoader.loadImage(
                // Cleartext HTTP traffic not permitted
                src.replace("http://", "https://", true),
                viewBinding.ivPic
        )
    }

    override fun setPreviewSrc(src: String) {
        // TODO: have I?
    }

    override fun setVotesCount(count: Int) {
        viewBinding.tvPicRating.text = context.getString(R.string.rating_pattern, count)
    }

    override fun setCommentsCount(count: Int) {
        viewBinding.tvPicComments.text = context.getString(R.string.comments_quantity, count)
    }
}