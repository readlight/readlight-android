package com.clean.custom

import android.app.Dialog
import android.content.Context
import android.view.Window
import kotlinx.android.synthetic.main.dialog_basic.*

class LitDialog(private val context: Context) {
    fun show(title: String, content: String) = Dialog(context, R.style.LitDialog).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_basic)
        text_title.text = title
        text_content.text = content
        button_confirm.setOnClickListener { dismiss() }
        layout_root.setOnClickListener { dismiss() }
    }.show()
}
