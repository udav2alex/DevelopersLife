package ru.gressor.developerslife.ui.adapter

import ru.gressor.developerslife.R
import ru.gressor.developerslife.databinding.ItemCommentBinding
import ru.gressor.developerslife.mvp.view.list.ICommentView

class CommentViewHolder(
        private val viewBinding: ItemCommentBinding
): ItemViewHolder(viewBinding), ICommentView {

    override fun setDate(date: String) {
        viewBinding.tvCommDate.text = date
    }

    override fun setText(text: String) {
        viewBinding.tvCommText.text = text
    }

    override fun setVoteCount(count: Int) {
        viewBinding.tvCommRating.text = context.getString(R.string.rating_pattern, count)
    }

    override fun setAuthor(author: String) {
        viewBinding.tvCommAuthor.text = author
    }
}