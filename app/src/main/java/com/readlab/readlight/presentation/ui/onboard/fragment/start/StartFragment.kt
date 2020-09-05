package com.readlab.readlight.presentation.ui.onboard.fragment.start

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.rx
import com.readlab.readlight.R
import com.readlab.readlight.databinding.FragmentStartBinding
import com.readlab.readlight.presentation.common.BaseFragment
import com.readlab.readlight.presentation.ui.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers

class StartFragment : BaseFragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.apply {
            statusBarColor = context?.getColor(R.color.colorAccent) ?: 0
        }

        binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.fragment = this
        return binding.root
    }

    fun kakaoLogin() = LoginClient.rx.loginWithKakaoTalk(parent)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }, { error ->
            Log.e("StartFragment", "로그인 실패", error)
        })

    fun startWithEmail() {
        val direction = StartFragmentDirections.actionStartFragmentToSignupFragment()
        findNavController().navigate(direction)
    }

    fun loginWithEmail() {
        val direction = StartFragmentDirections.actionStartFragmentToLoginFragment()
        findNavController().navigate(direction)
    }
}
