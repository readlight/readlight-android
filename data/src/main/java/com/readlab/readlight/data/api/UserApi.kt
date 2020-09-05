package com.readlab.readlight.data.api

import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.repositories.KakaoSocialLogInQuery
import com.readlab.readlight.domain.repositories.LogInQuery
import com.readlab.readlight.domain.repositories.SignUpQuery
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserApi {
    @POST("auth/signup")
    fun postSignUp(
        @Body query: SignUpQuery
    ): Single<Response<TokenResult>>

    @POST("auth/login")
    fun postLogIn(
        @Body query: LogInQuery
    ): Single<Response<TokenResult>>

    @PUT("auth/social-kakao")
    fun putKakaoSocialLogIn(
        @Body query: KakaoSocialLogInQuery
    ): Single<Response<TokenResult>>
}
