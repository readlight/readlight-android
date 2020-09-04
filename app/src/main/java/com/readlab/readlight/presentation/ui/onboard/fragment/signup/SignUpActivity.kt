package com.readlab.readlight.presentation.ui.onboard.fragment.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.clean.custom.LitDialog
import com.readlab.readlight.R
import com.readlab.readlight.databinding.ActivitySignupBinding
import com.readlab.readlight.presentation.security.Token
import com.readlab.readlight.presentation.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_signup.*
import org.koin.android.ext.android.inject

class SignUpActivity : AppCompatActivity() {
    private val signViewModel: SignUpViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignupBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.lifecycleOwner = this
        binding.vm = signViewModel

        signUpButton.run {
            setOnClickListener {
                signViewModel.signUp()
                startAnimation()
            }
        }

        signViewModel.signUpResult.observe(this, {
            signUpButton.revertAnimation()
            when (it.code()) {
                SUCCESS -> {
                    val token: String = it.body()?.token ?: ""
                    signUpSuccess(token)
                }
                INVALID_DATA -> LitDialog(this).show(
                    title = getString(R.string.text_invalid_data),
                    content = getString(R.string.text_invalid_data_notice)
                )
                UNKNOWN_API_ERROR -> LitDialog(this).show(
                    title = getString(R.string.text_server_error),
                    content = getString(R.string.text_server_error_notice)
                )
                DUPLICATED_EMAIL -> emailInputLayout.error =
                    getString(R.string.text_duplicated_email)
            }
        })
    }

    private fun signUpSuccess(token: String) {
        Token(this).set(token)
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}

private const val SUCCESS = 200
private const val DUPLICATED_EMAIL = 409
private const val INVALID_DATA = 412
private const val UNKNOWN_API_ERROR = 500
