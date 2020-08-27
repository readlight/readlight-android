package com.readlab.readlight.domain.repositories

import com.readlab.readlight.domain.common.Query
import com.readlab.readlight.domain.common.QueryField
import com.readlab.readlight.domain.model.Response
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun postSignIn(query: SignInQuery): Single<Response>
}

data class SignInQuery(
    @QueryField("name") var name: String = "",
    @QueryField("email") var email: String = "",
    @QueryField("password") var password: String = "",
    @QueryField("phone") var phone: String = ""
) : Query
