package ru.gressor.developerslife.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface PicsView : MvpView {
    fun updateList()
    fun showError(throwable: Throwable)
    fun showNoComments()
}