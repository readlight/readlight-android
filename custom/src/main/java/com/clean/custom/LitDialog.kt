package com.clean.custom

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class LitDialog(private val context: Context) {
    fun show(title: String, content: String) = Dialog(context, R.style.LitDialog).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_basic)
        findViewById<TextView>(R.id.text_title).text = title
        findViewById<TextView>(R.id.text_content).text = content
        findViewById<Button>(R.id.button_confirm).setOnClickListener { dismiss() }
        findViewById<LinearLayout>(R.id.layout_root).setOnClickListener { dismiss() }
        setCanceledOnTouchOutside(false)
    }.show()
}
