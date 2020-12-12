package ru.gressor.developerslife.mvp.view.list

interface IPicView: IListView {
    fun setAuthor(author: String)
    fun setDate(date: String)
    fun setDescription(desc: String)
    fun setImageSrc(src: String)
    fun setPreviewSrc(src: String)
    fun setVotesCount(count: Int)
    fun setCommentsCount(count: Int)
}