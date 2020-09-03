package com.readlab.readlight.presentation.network

import com.readlab.readlight.BuildConfig
import com.readlab.readlight.presentation.ui.util.toBase64
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ReadLightAuthInterceptor : Interceptor {
    private val userCredential = "account-basic:${BuildConfig.API_KEY}"
    private val authHeader = "Basic ${userCredential.toBase64()}"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val request = builder
            .addHeader("Authorization", authHeader)
            .addHeader("accept", "application/json; charset=utf-8")
            .removeHeader("Content-Type")
            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
            .build()

        return chain.proceed(request)
    }
}
