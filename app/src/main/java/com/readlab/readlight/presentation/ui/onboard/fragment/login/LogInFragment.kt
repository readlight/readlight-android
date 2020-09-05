package com.readlab.readlight.presentation.ui.onboard.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.clean.custom.LitDialog
import com.readlab.readlight.R
import com.readlab.readlight.databinding.FragmentLoginBinding
import com.readlab.readlight.presentation.common.BaseFragment
import com.readlab.readlight.presentation.security.Token
import com.readlab.readlight.presentation.ui.main.MainActivity
import org.koin.android.ext.android.inject

class LogInFragment : BaseFragment() {
    private val logInViewModel: LogInViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.apply {
            statusBarColor = context?.getColor(R.color.colorPrimary) ?: 0
        }

        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.vm = logInViewModel

        binding.signUpButton.setOnClickListener {
            val direction = LogInFragmentDirections.actionLoginFragmentToSignupFragment()
            findNavController().navigate(direction)
        }

        binding.logInButton.run {
            setOnClickListener {
                startAnimation()
                logInViewModel.logIn()
            }
        }

        logInViewModel.logInResult.observe(viewLifecycleOwner, {
            binding.logInButton.revertAnimation()
            when (it.code()) {
                SUCCESS -> {
                    val token: String = it.body()?.token ?: ""
                    Token(parent).set(token)
                    startActivity(Intent(activity, MainActivity::class.java))
                    activity?.finish()
                }
                NO_ACCOUNT -> {
                    binding.emailInputLayout.error =
                        getString(R.string.text_wrong_email_or_password)
                    binding.passwordInputLayout.error =
                        getString(R.string.text_wrong_email_or_password)
                }
                INVALID_DATA -> LitDialog(parent).show(
                    title = getString(R.string.text_invalid_data),
                    content = getString(R.string.text_invalid_data_notice)
                )
                ACCOUNT_CLOSED -> LitDialog(parent).show(
                    title = getString(R.string.text_account_closed),
                    content = getString(R.string.text_account_closed_notice)
                )
                UNKNOWN_API_ERROR -> LitDialog(parent).show(
                    title = getString(R.string.text_server_error),
                    content = getString(R.string.text_server_error_notice)
                )
            }
        })

        return binding.root
    }
}

private const val SUCCESS = 200
private const val NO_ACCOUNT = 409
private const val INVALID_DATA = 412
private const val ACCOUNT_CLOSED = 423
private const val UNKNOWN_API_ERROR = 500
