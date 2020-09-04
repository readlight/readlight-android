package com.readlab.readlight.presentation.ui.onboard.fragment.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.readlab.readlight.R
import com.readlab.readlight.databinding.ActivityLoginBinding
import com.readlab.readlight.presentation.ui.onboard.fragment.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LogInActivity : AppCompatActivity() {
    private val logInViewModel: LogInViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.vm = logInViewModel

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}
