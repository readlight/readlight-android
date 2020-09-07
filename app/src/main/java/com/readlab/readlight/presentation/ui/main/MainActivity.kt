package com.readlab.readlight.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.readlab.readlight.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragments = listOf(Fragment())

        mainViewPager.adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle, fragments)
    }
}
