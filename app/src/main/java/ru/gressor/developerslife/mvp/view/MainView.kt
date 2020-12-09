package ru.gressor.developerslife.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView : MvpView {
    fun showError(throwable: Throwable)
}