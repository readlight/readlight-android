package com.clean.custom

import android.app.Dialog
import android.content.Context
import android.view.Window

class LitProgressDialog(private val context: Context) {
    private val dialog = Dialog(context, R.style.LitDialog).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_progress)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    fun show() = dialog.show()

    fun stop() = dialog.dismiss()
}
