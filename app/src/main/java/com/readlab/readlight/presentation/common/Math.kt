package com.readlab.readlight.presentation.common

import android.util.Base64
import java.math.BigDecimal

fun String.toBase64(): String = Base64.encodeToString(this.toByteArray(), Base64.NO_WRAP)

fun Double.round(decimals: Int) = BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()

val Int.second: Long
    get() {
        return (this * 1000).toLong()
    }

val Long.millisecond: Double
    get() {
        return (this / 1000.0)
    }
