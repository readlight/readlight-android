package com.readlab.readlight.domain.repositories

import com.readlab.readlight.domain.model.Response
import com.readlab.readlight.domain.model.TokenResponse
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun postSignIn(query: SignInQuery): Single<Response>
    fun postLogIn(query: LogInQuery): Single<TokenResponse>
}

data class SignInQuery(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var phone: String = ""
)

data class LogInQuery(
    var email: String = "",
    var password: String = ""
)
