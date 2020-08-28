package com.readlab.readlight.presentation.ui.signup

import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.readlab.readlight.domain.repositories.SignInQuery
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.BaseViewModel

class SignUpViewModel(private val userUseCase: UserUseCase) : BaseViewModel() {
    val userQuery = MutableLiveData<SignInQuery>(SignInQuery())

    fun signIn(query: SignInQuery) {
        val disposable = userUseCase
            .postSignIn(query)
            .subscribe({ response ->
                Logger.d("On Next Called: $response")
                if (response != null) {
                    Logger.d("Sign In Success")
                } else {
                    Logger.d("Response is null!")
                }
            }, {
                Logger.d("On Error!: $it")
            })

        addDisposable(disposable)
    }
}
