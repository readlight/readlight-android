package com.readlab.readlight.domain.repositories

import com.clean.util.emailRegularExpression
import com.clean.util.passwordRegularExpression
import com.readlab.readlight.domain.model.TokenResult
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface UserRepository {
    fun postSignUp(query: SignUpQuery): Single<Response<TokenResult>>
    fun postLogIn(query: LogInQuery): Single<Response<TokenResult>>
}

data class SignUpQuery(
    var email: String = "",
    var password: String = "",
    var name: String = "",
    var phone: String = "",
    var isTermAgreed: Boolean = false,
    var isAlarmReceptionAgreed: Boolean = false
) {
    fun isValid() = Companion.isValid(email, password, name, phone, isTermAgreed)

    companion object {
        fun isNameValid(name: String?) = !name.isNullOrBlank()
        fun isPhoneValid(phone: String?) = !phone.isNullOrBlank()
        fun isEmailValid(email: String?) = email?.matches(emailRegularExpression) ?: false
        fun isPasswordValid(password: String?) =
            password?.matches(passwordRegularExpression) ?: false

        @JvmStatic
        fun isValid(
            email: String?,
            password: String?,
            name: String?,
            phone: String?,
            isTermAgreed: Boolean
        ) = isNameValid(name) &&
                isPhoneValid(phone) &&
                isEmailValid(email) &&
                isPasswordValid(password) &&
                isTermAgreed
    }
}

data class LogInQuery(
    var email: String = "",
    var password: String = ""
)
