package com.readlab.readlight.presentation.ui.onboard.fragment.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.usecase.UserUseCase
import retrofit2.Response

class StartViewModel(private val userUseCase: UserUseCase) : ViewModel() {
    val startWithKakaoResult = MutableLiveData<Response<TokenResult>>()

    fun startWithKakao() {

    }
}
