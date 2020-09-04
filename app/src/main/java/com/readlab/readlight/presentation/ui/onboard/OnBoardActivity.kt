package com.readlab.readlight.presentation.ui.onboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.readlab.readlight.R
import com.readlab.readlight.databinding.ActivityOnboardBinding

class OnBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityOnboardBinding>(this, R.layout.activity_onboard)
    }
}
