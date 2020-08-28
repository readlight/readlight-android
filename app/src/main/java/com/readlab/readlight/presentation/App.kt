package com.readlab.readlight.presentation

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.readlab.readlight.BuildConfig
import com.readlab.readlight.presentation.di.mNetworkModules
import com.readlab.readlight.presentation.di.mRepository
import com.readlab.readlight.presentation.di.mUseCases
import com.readlab.readlight.presentation.di.mViewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(mNetworkModules, mRepository, mUseCases, mViewModels)
        }

        KakaoSdk.init(this, BuildConfig.KAKAO_API_KEY)

        Logger.addLogAdapter(AndroidLogAdapter())
    }
}
