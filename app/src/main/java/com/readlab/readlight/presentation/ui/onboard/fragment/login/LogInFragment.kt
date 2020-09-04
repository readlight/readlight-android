package com.readlab.readlight.presentation.ui.onboard.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.readlab.readlight.databinding.FragmentLoginBinding
import com.readlab.readlight.presentation.common.BaseFragment
import com.readlab.readlight.presentation.ui.main.MainActivity
import org.koin.android.ext.android.inject

class LogInFragment : BaseFragment() {
    private val logInViewModel: LogInViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.vm = logInViewModel

        binding.signUpButton.setOnClickListener {
            val direction = LogInFragmentDirections.actionLoginFragmentToSignupFragment()
            findNavController().navigate(direction)
        }

        binding.logInButton.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }

        return binding.root
    }
}
