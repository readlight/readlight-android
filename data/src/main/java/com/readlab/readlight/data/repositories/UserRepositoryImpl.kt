package com.readlab.readlight.data.repositories

import com.readlab.readlight.data.api.UserApi
import com.readlab.readlight.domain.model.Response
import com.readlab.readlight.domain.repositories.SignInQuery
import com.readlab.readlight.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl(private val api: UserApi) : UserRepository {
    override fun postSignIn(query: SignInQuery): Single<Response> {
        return api.postSignIn(query)
    }
}
