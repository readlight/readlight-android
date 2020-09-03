package com.readlab.readlight.presentation.ui.util

fun String.validate(regex: Regex, message: String) = if (this.matches(regex)) {
    null
} else {
    message
}

