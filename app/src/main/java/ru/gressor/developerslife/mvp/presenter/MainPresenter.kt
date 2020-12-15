package ru.gressor.developerslife.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gressor.developerslife.mvp.view.MainView
import ru.gressor.developerslife.navigation.Screens
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.picsList())
    }

    fun backPressed() {
        viewState.showError(Throwable("Goodbye! ;)"))
        router.exit()
    }
}