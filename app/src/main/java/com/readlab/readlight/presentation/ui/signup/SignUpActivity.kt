package com.readlab.readlight.presentation.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.readlab.readlight.R
import com.readlab.readlight.databinding.ActivitySignupBinding
import com.readlab.readlight.domain.repositories.SignInQuery
import kotlinx.android.synthetic.main.activity_main.signUpButton
import kotlinx.android.synthetic.main.activity_signup.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity() {
    private val signViewModel: SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignupBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.vm = signViewModel

        signUpButton.setOnClickListener {
            val query = SignInQuery(
                nameEdit.text.toString(),
                emailEdit.text.toString(),
                passwordEdit.text.toString(),
                phoneNumberEdit.text.toString()
            )

            signViewModel.signIn(
                SignInQuery(
                    nameEdit.text.toString(),
                    emailEdit.text.toString(),
                    passwordEdit.text.toString(),
                    phoneNumberEdit.text.toString()
                )
            )
        }
    }
}
