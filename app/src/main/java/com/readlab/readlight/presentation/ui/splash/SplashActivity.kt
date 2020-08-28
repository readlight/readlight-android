package com.readlab.readlight.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.readlab.readlight.presentation.ui.onboard.OnBoardActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, OnBoardActivity::class.java))
        finish()
    }
}
