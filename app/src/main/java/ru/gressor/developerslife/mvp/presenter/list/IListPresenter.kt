package ru.gressor.developerslife.mvp.presenter.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?

    fun getCount(): Int
    fun bindView(view: V)
}