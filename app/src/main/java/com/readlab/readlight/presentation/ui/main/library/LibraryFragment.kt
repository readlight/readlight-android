package com.readlab.readlight.presentation.ui.main.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.readlab.readlight.databinding.FragmentLibraryBinding
import com.readlab.readlight.presentation.common.BaseFragment

class LibraryFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }
}
