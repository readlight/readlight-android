package com.readlab.readlight.presentation.common

import android.content.Context
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseFragment : Fragment() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    protected lateinit var parent: Context

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun clearDisposables() {
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearDisposables()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parent = context
    }
}
