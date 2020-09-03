package com.readlab.readlight.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

fun <T> LiveData<T>.ignoreFirst(): MutableLiveData<T> {
    val result = MediatorLiveData<T>()
    var isFirst = true
    result.addSource(this) {
        if (isFirst) isFirst = false
        else result.value = it
    }
    return result
}
