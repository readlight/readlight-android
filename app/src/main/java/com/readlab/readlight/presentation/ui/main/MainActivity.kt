package com.readlab.readlight.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.readlab.readlight.R
import com.readlab.readlight.presentation.ui.main.ensemble.EnsembleFragment
import com.readlab.readlight.presentation.ui.main.feed.FeedFragment
import com.readlab.readlight.presentation.ui.main.library.LibraryFragment
import com.readlab.readlight.presentation.ui.main.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items =
            listOf(R.id.daily_feed, R.id.search, R.id.library, R.id.ensemble)
        val fragments =
            listOf(FeedFragment(), SearchFragment(), LibraryFragment(), EnsembleFragment())

        mainViewPager.apply {
            adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle, fragments)
            isUserInputEnabled = false
        }

        bottom_navigation.setOnNavigationItemSelectedListener {
            mainViewPager.setCurrentItem(items.indexOf(it.itemId), false)
            true
        }
    }
}
