package ru.gressor.developerslife.mvp.view.list

interface ICommentView: IListView {
    fun setDate(date: String)
    fun setText(text: String)
    fun setVoteCount(count: Int)
    fun setAuthor(author: String)
}