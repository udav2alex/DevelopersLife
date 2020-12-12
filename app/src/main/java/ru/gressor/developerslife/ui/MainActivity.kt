package ru.gressor.developerslife.ui

import android.os.Bundle
import android.widget.Toast
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.gressor.developerslife.R
import ru.gressor.developerslife.mvp.presenter.MainPresenter
import ru.gressor.developerslife.mvp.view.MainView
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    @Inject lateinit var navigatorHolder: NavigatorHolder

    private val navigator =
            AppNavigator(this, R.id.fl_fragment_container, supportFragmentManager)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackPressedListener && it.backPressed()) {
                return
            }
        }
        presenter.backPressed()
    }
}