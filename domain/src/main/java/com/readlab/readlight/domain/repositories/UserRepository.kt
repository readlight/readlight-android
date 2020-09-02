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
    fun isValid() = Companion.isValid(name, email, password, phone)

    companion object {
        fun isNameValid(name: String?) = !name.isNullOrBlank()
        fun isPhoneValid(phone: String?) = !phone.isNullOrBlank()
        fun isEmailValid(email: String?) = email?.matches(emailRegularExpression) ?: false
        fun isPasswordValid(password: String?) =
            password?.matches(passwordRegularExpression) ?: false

        @JvmStatic
        fun isValid(
            name: String?,
            email: String?,
            password: String?,
            phone: String?
        ) = isNameValid(name) &&
                isPhoneValid(phone) &&
                isEmailValid(email) &&
                isPasswordValid(password)

    }
}

data class LogInQuery(
    var email: String = "",
    var password: String = ""
)
