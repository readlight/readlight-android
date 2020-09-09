package com.readlab.readlight.presentation.ui.main.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.readlab.readlight.databinding.FragmentFeedBinding
import com.readlab.readlight.presentation.common.BaseFragment

class FeedFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }
}
