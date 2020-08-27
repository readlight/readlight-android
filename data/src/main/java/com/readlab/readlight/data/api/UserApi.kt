package com.readlab.readlight.data.api

import com.readlab.readlight.domain.model.Response
import com.readlab.readlight.domain.repositories.SignInQuery
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("auth/signup")
    fun postSignIn(
        @Body query: SignInQuery
    ): Single<Response>
}
