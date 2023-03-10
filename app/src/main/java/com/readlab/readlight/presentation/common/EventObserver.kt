package com.readlab.readlight.presentation.common

import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandledContent: (T?) -> Unit) : Observer<Event<T>> {
    override fun onChanged(value: Event<T>) {
        value ?: return

        if (value.content == null && !value.hasBeenHandled) {
            value.getContentIfNotHandled()
            onEventUnhandledContent(null)
            return
        }

        value.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }

}
