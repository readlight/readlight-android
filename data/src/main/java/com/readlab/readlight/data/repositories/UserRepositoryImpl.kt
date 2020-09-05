package com.readlab.readlight.data.repositories

import com.readlab.readlight.data.api.UserApi
import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.repositories.KakaoSocialLogInQuery
import com.readlab.readlight.domain.repositories.LogInQuery
import com.readlab.readlight.domain.repositories.SignUpQuery
import com.readlab.readlight.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class UserRepositoryImpl(private val api: UserApi) : UserRepository {
    override fun postSignUp(query: SignUpQuery): Single<Response<TokenResult>> {
        return api.postSignUp(query)
    }

    override fun postLogIn(query: LogInQuery): Single<Response<TokenResult>> {
        return api.postLogIn(query)
    }

    override fun putKakaoSocialLogIn(query: KakaoSocialLogInQuery): Single<Response<TokenResult>> {
        return api.putKakaoSocialLogIn(query)
    }
}
