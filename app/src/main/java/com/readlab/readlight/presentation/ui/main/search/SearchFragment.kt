package com.readlab.readlight.presentation.ui.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.readlab.readlight.databinding.FragmentSearchBinding
import com.readlab.readlight.presentation.common.BaseFragment

class SearchFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
}
