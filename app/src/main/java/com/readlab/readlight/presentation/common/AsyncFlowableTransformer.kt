package com.readlab.readlight.presentation.common

import com.readlab.readlight.domain.common.SingleRxTransformer
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.schedulers.Schedulers

class AsyncFlowableTransformer<T : Any> : SingleRxTransformer<T>() {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.async()
    }
}

fun <T : Any> Single<T>.async(): Single<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}
