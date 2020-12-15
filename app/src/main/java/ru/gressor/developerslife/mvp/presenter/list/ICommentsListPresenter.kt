package ru.gressor.developerslife.mvp.presenter.list

import ru.gressor.developerslife.mvp.view.list.IListView

interface ICommentsListPresenter : IListPresenter<IListView> {
    fun getItemViewType(position: Int): Int
}