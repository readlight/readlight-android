package com.readlab.readlight.presentation.ui.util

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

object BindingUtils {
    @JvmStatic
    @BindingAdapter("app:errorText")
    fun TextInputLayout.setErrorText(errorText: String?) {
        error = errorText
    }
}
