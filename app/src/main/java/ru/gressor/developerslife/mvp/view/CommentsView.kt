package ru.gressor.developerslife.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CommentsView : MvpView {
    fun updateList()
    fun showError(throwable: Throwable)
    fun release()
}