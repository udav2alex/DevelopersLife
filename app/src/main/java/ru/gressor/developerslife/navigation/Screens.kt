package ru.gressor.developerslife.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gressor.developerslife.mvp.model.entity.Pic
import ru.gressor.developerslife.ui.fragment.CommentsFragment
import ru.gressor.developerslife.ui.fragment.PicsFragment

object Screens {
    fun picsList() = FragmentScreen { PicsFragment.newInstance() }
    fun commentsList(pic: Pic) = FragmentScreen { CommentsFragment.newInstance(pic) }
}