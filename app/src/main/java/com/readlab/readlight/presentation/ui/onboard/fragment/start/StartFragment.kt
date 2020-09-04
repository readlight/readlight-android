package com.readlab.readlight.presentation.ui.onboard.fragment.start

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.rx
import com.readlab.readlight.databinding.FragmentStartBinding
import com.readlab.readlight.presentation.common.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers


class StartFragment : BaseFragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.fragment = this
        return binding.root
    }

    fun kakaoLogin() = LoginClient.rx.loginWithKakaoTalk(parent)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            //startActivity(Intent(this, MainActivity::class.java))
            //finish()
        }, { error ->
            Log.e("StartFragment", "로그인 실패", error)
        })

    fun startWithEmail() {
        //startActivity(Intent(this, SignUpActivity::class.java))
    }

    fun loginWithEmail() {
        //startActivity(Intent(this, LogInActivity::class.java))
    }
}
