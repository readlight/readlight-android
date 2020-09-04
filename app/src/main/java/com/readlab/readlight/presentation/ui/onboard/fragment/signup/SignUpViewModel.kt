package com.readlab.readlight.presentation.ui.onboard.fragment.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.orhanobut.logger.Logger
import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.repositories.SignUpQuery
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.BaseViewModel
import retrofit2.Response

class SignUpViewModel(private val userUseCase: UserUseCase) : BaseViewModel() {
    val signUpResult = MutableLiveData<Response<TokenResult>>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val name = MutableLiveData("")
    val phone = MutableLiveData("")

    val isTermAgreed = MutableLiveData(false)
    val isAlarmReceptionAgreed = MutableLiveData(false)

    val isEmailValid = Transformations.map(email) {
        return@map SignUpQuery.isEmailValid(it)
    }
    val isPasswordValid = Transformations.map(password) {
        return@map SignUpQuery.isPasswordValid(it)
    }

    fun signUp() {
        val userQuery = SignUpQuery(
            email.value ?: "",
            password.value ?: "",
            name.value ?: "",
            phone.value ?: "",
            isTermAgreed.value ?: false,
            isAlarmReceptionAgreed.value ?: false
        )
        if (!userQuery.isValid()) return
        Logger.d(userQuery)

        val disposable = userUseCase
            .postSignUp(userQuery)
            .subscribe({ response ->
                Logger.d("On Next Called: $response")
                signUpResult.value = response
            }, {
                Logger.e("On Error: $it")
                //Todo: signUpResult 로 데이터 전달
            })
        addDisposable(disposable)
    }
}
