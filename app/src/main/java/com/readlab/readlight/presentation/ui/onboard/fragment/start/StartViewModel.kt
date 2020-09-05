package com.readlab.readlight.presentation.ui.onboard.fragment.start

import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.repositories.KakaoSocialLogInQuery
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.BaseViewModel
import retrofit2.Response

class StartViewModel(private val userUseCase: UserUseCase) : BaseViewModel() {
    val startWithKakaoResult = MutableLiveData<Response<TokenResult>>()

    fun startWithKakao(token: String) {
        val disposable = userUseCase
            .putKakaoSocialLogIn(KakaoSocialLogInQuery(token))
            .subscribe({ response ->
                Logger.d("On Next Called: $response")
                startWithKakaoResult.value = response
            }, {
                Logger.e("On Error: $it")
            })

        addDisposable(disposable)
    }
}
