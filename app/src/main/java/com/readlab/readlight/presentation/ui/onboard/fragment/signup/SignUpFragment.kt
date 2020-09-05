package com.readlab.readlight.presentation.ui.onboard.fragment.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clean.custom.LitDialog
import com.readlab.readlight.R
import com.readlab.readlight.databinding.FragmentSignupBinding
import com.readlab.readlight.presentation.common.BaseFragment
import com.readlab.readlight.presentation.security.Token
import com.readlab.readlight.presentation.ui.main.MainActivity
import org.koin.android.ext.android.inject

class SignUpFragment : BaseFragment() {
    private val signViewModel: SignUpViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.statusBarColor = context?.getColor(R.color.colorPrimary) ?: 0
        val binding = FragmentSignupBinding.inflate(inflater, container, false)
        binding.vm = signViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.signUpButton.run {
            setOnClickListener {
                signViewModel.signUp()
                startAnimation()
            }
        }

        signViewModel.signUpResult.observe(viewLifecycleOwner, {
            binding.signUpButton.revertAnimation()
            when (it.code()) {
                SUCCESS -> {
                    val token: String = it.body()?.token ?: ""
                    signUpSuccess(token)
                }
                INVALID_DATA -> LitDialog(parent).show(
                    title = getString(R.string.text_invalid_data),
                    content = getString(R.string.text_invalid_data_notice)
                )
                UNKNOWN_API_ERROR -> LitDialog(parent).show(
                    title = getString(R.string.text_server_error),
                    content = getString(R.string.text_server_error_notice)
                )
                DUPLICATED_EMAIL -> binding.emailInputLayout.error =
                    getString(R.string.text_duplicated_email)
            }
        })

        return binding.root
    }

    private fun signUpSuccess(token: String) {
        Token(parent).set(token)
        startActivity(Intent(parent, MainActivity::class.java))
        activity?.finish()
    }
}

private const val SUCCESS = 200
private const val DUPLICATED_EMAIL = 409
private const val INVALID_DATA = 412
private const val UNKNOWN_API_ERROR = 500
