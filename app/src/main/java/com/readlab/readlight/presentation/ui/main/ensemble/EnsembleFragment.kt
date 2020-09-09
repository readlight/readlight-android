package com.readlab.readlight.presentation.ui.main.ensemble

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.readlab.readlight.databinding.FragmentEnsembleBinding
import com.readlab.readlight.presentation.common.BaseFragment

class EnsembleFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEnsembleBinding.inflate(inflater, container, false)
        return binding.root
    }
}
