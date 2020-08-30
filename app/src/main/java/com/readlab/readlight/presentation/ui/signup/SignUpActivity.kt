package com.readlab.readlight.presentation.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.readlab.readlight.R
import com.readlab.readlight.databinding.ActivitySignupBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class SignUpActivity : AppCompatActivity() {
    private val signViewModel: SignUpViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignupBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.vm = signViewModel

        signUpButton.setOnClickListener {
            signViewModel.signIn()
        }
    }
}
