package com.readlab.readlight.presentation.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.orhanobut.logger.Logger
import com.readlab.readlight.domain.repositories.SignUpQuery
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.BaseViewModel

class SignUpViewModel(private val userUseCase: UserUseCase) : BaseViewModel() {
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val name = MutableLiveData("")
    val phone = MutableLiveData("")

    val isEmailValid = Transformations.map(email) {
        return@map SignUpQuery.isEmailValid(it)
    }
    val isPasswordValid = Transformations.map(password) {
        return@map SignUpQuery.isPasswordValid(it)
    }

    fun signUp() {
        val userQuery = SignUpQuery(
            name.value ?: return,
            email.value ?: return,
            password.value ?: return,
            phone.value ?: return
        )
        if (!userQuery.isValid()) return // Todo : Handle these returns
        val disposable = userUseCase
            .postSignUp(userQuery)
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
