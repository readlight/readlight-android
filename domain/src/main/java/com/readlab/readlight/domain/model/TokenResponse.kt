package com.readlab.readlight.domain.model

class TokenResponse(
    result: String,
    val token: String
) : Response(result)
