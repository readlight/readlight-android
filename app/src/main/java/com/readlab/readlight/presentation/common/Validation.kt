package com.readlab.readlight.presentation.common

fun String.validate(regex: Regex, message: String) = if (this.matches(regex)) {
    null
} else {
    message
}

