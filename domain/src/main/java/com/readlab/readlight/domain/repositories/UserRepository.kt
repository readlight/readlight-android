package com.readlab.readlight.domain.repositories

import com.clean.util.emailRegularExpression
import com.clean.util.passwordRegularExpression
import com.readlab.readlight.domain.model.Response
import com.readlab.readlight.domain.model.TokenResponse
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun postSignUp(query: SignUpQuery): Single<Response>
    fun postLogIn(query: LogInQuery): Single<TokenResponse>
}

data class SignUpQuery(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var phone: String = ""
) {
    fun isValidate(): Boolean {
        return !(
                name.isEmpty()
                        || email.isEmpty()
                        || password.isEmpty()
                        || phone.isEmpty()
                        || !(email.matches(emailRegularExpression) && password.matches(
                    passwordRegularExpression
                ))
                )
    }
}

data class LogInQuery(
    var email: String = "",
    var password: String = ""
)
