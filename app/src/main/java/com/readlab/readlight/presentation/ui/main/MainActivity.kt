package com.readlab.readlight.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.readlab.readlight.R
import com.readlab.readlight.presentation.security.Token
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tokenText.text = Token(this).get()
    }
}
