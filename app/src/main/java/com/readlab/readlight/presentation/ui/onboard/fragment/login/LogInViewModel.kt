package com.readlab.readlight.presentation.ui.onboard.fragment.login

import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.readlab.readlight.domain.repositories.LogInQuery
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.BaseViewModel

class LogInViewModel(private val userUseCase: UserUseCase) : BaseViewModel() {
    val loginQuery = MutableLiveData<LogInQuery>(LogInQuery())

    fun logIn() {
        val query = loginQuery.value ?: return

        val disposable = userUseCase
            .postLogIn(query)
            .subscribe({ response ->
                Logger.d("On Next Called: $response")
                if (response != null) {
                    Logger.d("Log In Success")
                } else {
                    Logger.d("Response is null!")
                }
            }, {
                Logger.d("On Error!: $it")
            })

        addDisposable(disposable)
    }
}
