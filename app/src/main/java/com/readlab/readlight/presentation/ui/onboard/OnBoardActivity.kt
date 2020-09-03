package com.readlab.readlight.presentation.ui.onboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.rx
import com.readlab.readlight.R
import com.readlab.readlight.databinding.ActivityOnboardBinding
import com.readlab.readlight.presentation.ui.login.LogInActivity
import com.readlab.readlight.presentation.ui.main.MainActivity
import com.readlab.readlight.presentation.ui.signup.SignUpActivity
import io.reactivex.android.schedulers.AndroidSchedulers

class OnBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityOnboardBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_onboard)
        binding.activity = this
    }

    fun kakaoLogin() = LoginClient.rx.loginWithKakaoTalk(this)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, { error ->
            Log.e("OnBoardActivity", "로그인 실패", error)
        })

    fun startWithEmail() {
        startActivity(Intent(this, SignUpActivity::class.java))
        //finishAffinity()
    }

    fun loginWithEmail() {
        startActivity(Intent(this, LogInActivity::class.java))
        //finishAffinity()
    }
}
