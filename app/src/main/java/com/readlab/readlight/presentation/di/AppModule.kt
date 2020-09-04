package com.readlab.readlight.presentation.di

import com.readlab.readlight.data.api.UserApi
import com.readlab.readlight.data.repositories.UserRepositoryImpl
import com.readlab.readlight.domain.model.TokenResult
import com.readlab.readlight.domain.repositories.UserRepository
import com.readlab.readlight.domain.usecase.UserUseCase
import com.readlab.readlight.presentation.common.AsyncFlowableTransformer
import com.readlab.readlight.presentation.network.httpClient
import com.readlab.readlight.presentation.network.retrofitClient
import com.readlab.readlight.presentation.ui.onboard.fragment.login.LogInViewModel
import com.readlab.readlight.presentation.ui.onboard.fragment.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Response
import retrofit2.Retrofit

val mRepository = module {
    single<UserRepository>(named(USER_REPOSITORY)) { UserRepositoryImpl(get(named(USER_API))) }
}

val mUseCases = module {
    single {
        UserUseCase(
            get(named(USER_REPOSITORY)),
            AsyncFlowableTransformer<Response<TokenResult>>()
        )
    }
}

val mNetworkModules = module {
    single(named(READLIGHT_HTTP)) { httpClient() }
    single(named(READLIGHT_CLIENT)) { retrofitClient(BASE_URL, get(named(READLIGHT_HTTP))) }
    single<UserApi>(named(USER_API)) { (get(named(READLIGHT_CLIENT)) as Retrofit).create(UserApi::class.java) }
}

val mViewModels = module {
    viewModel { SignUpViewModel(get()) }
    viewModel { LogInViewModel(get()) }
}

const val BASE_URL = "https://api.readlight.me/"
const val READLIGHT_HTTP = "READLIGHT_HTTP"
const val READLIGHT_CLIENT = "READLIGHT_CLIENT"
const val USER_API = "USER_API"
const val USER_REPOSITORY = "USER_REPOSITORY"
