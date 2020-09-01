package com.readlab.readlight.data.repositories

import com.readlab.readlight.data.api.UserApi
import com.readlab.readlight.domain.model.Response
import com.readlab.readlight.domain.model.TokenResponse
import com.readlab.readlight.domain.repositories.LogInQuery
import com.readlab.readlight.domain.repositories.SignUpQuery
import com.readlab.readlight.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl(private val api: UserApi) : UserRepository {
    override fun postSignUp(query: SignUpQuery): Single<Response> {
        return api.postSignUp(query)
    }

    override fun postLogIn(query: LogInQuery): Single<TokenResponse> {
        return api.postLogIn(query)
    }
}
