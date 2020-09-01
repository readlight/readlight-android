package com.readlab.readlight.presentation.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.clean.util.emailRegularExpression
import com.clean.util.passwordRegularExpression
import com.readlab.readlight.R
import com.readlab.readlight.databinding.ActivitySignupBinding
import com.readlab.readlight.presentation.common.validate
import kotlinx.android.synthetic.main.activity_signup.*
import org.koin.android.ext.android.inject

class SignUpActivity : AppCompatActivity() {
    private val signViewModel: SignUpViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignupBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.vm = signViewModel

        signViewModel.email.observe(this, Observer {
            emailInputLayout.error = it.validate(
                emailRegularExpression,
                "이메일 형식이 올바르지 않습니다"
            )
            checkValidate()
        })
        signViewModel.password.observe(this, Observer {
            passwordInputLayout.error = it.validate(
                passwordRegularExpression,
                "8~20자 사이로 영문, 숫자, 특수문자를 1개 이상 포함해야합니다"
            )
            checkValidate()
        })
        signViewModel.name.observe(this, Observer {
            checkValidate()
        })
        signViewModel.phone.observe(this, Observer {
            checkValidate()
        })
    }

    private fun checkValidate() {
        signUpButton.able = signViewModel.userQuery.isValidate()
    }
}
