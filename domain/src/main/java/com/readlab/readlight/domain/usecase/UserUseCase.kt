package com.readlab.readlight.domain.usecase

import com.readlab.readlight.domain.common.SingleRxTransformer
import com.readlab.readlight.domain.model.Response
import com.readlab.readlight.domain.model.TokenResponse
import com.readlab.readlight.domain.repositories.LogInQuery
import com.readlab.readlight.domain.repositories.SignUpQuery
import com.readlab.readlight.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class UserUseCase(
    private val repository: UserRepository,
    private val transformer: SingleRxTransformer<Response>
) {
    fun postSignUp(query: SignUpQuery = SignUpQuery()): Single<Response> {
        return repository.postSignUp(query).compose(transformer)
    }

    fun postLogIn(query: LogInQuery = LogInQuery()): Single<TokenResponse> {
        return repository.postLogIn(query).compose(transformer).cast(TokenResponse::class.java)
    }
}
