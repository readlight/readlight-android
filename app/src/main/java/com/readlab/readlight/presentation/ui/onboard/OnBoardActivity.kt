package com.readlab.readlight.presentation.ui.onboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.rx
import com.readlab.readlight.R
import com.readlab.readlight.presentation.ui.login.LogInActivity
import com.readlab.readlight.presentation.ui.main.MainActivity
import com.readlab.readlight.presentation.ui.signup.SignUpActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_onboard.*

class OnBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)

        startWithKakaoButton.setOnClickListener {
            LoginClient.rx.loginWithKakaoTalk(this)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ token ->
                    startActivity(Intent(this, MainActivity::class.java))
                }, { error ->
                    Log.e("OnBoardActivity", "로그인 실패", error)
                })
        }

        startWithEmailButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        loginWithEmailButton.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
        }
    }
}
