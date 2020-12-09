package ru.gressor.developerslife.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gressor.developerslife.ui.fragments.PicsFragment

object Screens {
    fun main() = FragmentScreen { PicsFragment.newInstance() }
}