package com.readlab.readlight.domain.usecase

import com.readlab.readlight.domain.common.SingleRxTransformer
import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.repositories.KakaoSocialLogInQuery
import com.readlab.readlight.domain.repositories.LogInQuery
import com.readlab.readlight.domain.repositories.SignUpQuery
import com.readlab.readlight.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class UserUseCase(
    private val repository: UserRepository,
    private val transformer: SingleRxTransformer<Response<TokenResult>>
) {
    fun postSignUp(query: SignUpQuery): Single<Response<TokenResult>> {
        return repository.postSignUp(query).compose(transformer)
    }

    fun postLogIn(query: LogInQuery): Single<Response<TokenResult>> {
        return repository.postLogIn(query).compose(transformer)
    }

    fun putKakaoSocialLogIn(query: KakaoSocialLogInQuery): Single<Response<TokenResult>> {
        return repository.putKakaoSocialLogIn(query).compose(transformer)
    }
}
