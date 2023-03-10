package com.readlab.readlight.domain.common

import io.reactivex.rxjava3.core.SingleTransformer

abstract class SingleRxTransformer<T : Any> : SingleTransformer<T, T>
