package com.readlab.readlight.presentation.ui.onboard.fragment.login

import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.repositories.LogInQuery
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.BaseViewModel
import retrofit2.Response

class LogInViewModel(private val userUseCase: UserUseCase) : BaseViewModel() {
    val logInResult = MutableLiveData<Response<TokenResult>>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun logIn() {
        val userQuery = LogInQuery(
            email.value ?: "",
            password.value ?: "",
        )

        val disposable = userUseCase
            .postLogIn(userQuery)
            .subscribe({ response ->
                Logger.d("On Next Called: $response")
                if (response != null) {
                    Logger.d("Log In Success")
                    logInResult.value = response
                } else {
                    Logger.d("Response is null!")
                }
            }, {
                Logger.d("On Error!: $it")
            })

        addDisposable(disposable)
    }
}
