package com.readlab.readlight.presentation.ui.onboard.fragment.start

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.clean.custom.LitDialog
import com.clean.custom.LitProgressDialog
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.rx
import com.readlab.readlight.R
import com.readlab.readlight.databinding.FragmentStartBinding
import com.readlab.readlight.presentation.common.BaseFragment
import com.readlab.readlight.presentation.security.Token
import com.readlab.readlight.presentation.ui.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartFragment : BaseFragment() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val progressDialog by lazy { LitProgressDialog(parent) }
    private val dialog by lazy { LitDialog(parent) }
    private val startViewModel: StartViewModel by viewModel()
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.statusBarColor = parent.getColor(R.color.colorAccent)

        binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.fragment = this

        startViewModel.startWithKakaoResult.observe(viewLifecycleOwner, {
            compositeDisposable.clear()
            progressDialog.stop()
            when (it.code()) {
                SUCCESS -> {
                    it.body()?.token?.let { token -> Token(parent).set(token) }
                    startActivity(Intent(activity, MainActivity::class.java))
                    activity?.finish()
                }
                LOGIN_WITH_EMAIL -> dialog.show(
                    title = getString(R.string.text_server_error),
                    content = getString(R.string.text_server_error_notice)
                )
                INVALID_DATA -> dialog.show(
                    title = getString(R.string.text_invaild_kakao_account),
                    content = getString(R.string.text_invaild_kakao_account_notice)
                )
                ACCOUNT_CLOSED -> dialog.show(
                    title = getString(R.string.text_account_closed),
                    content = getString(R.string.text_account_closed_notice)
                )
                FAILED_TO_GET_TOKEN -> {
                    startWithKakao()
                }
                UNKNOWN_API_ERROR -> dialog.show(
                    title = getString(R.string.text_server_error),
                    content = getString(R.string.text_server_error_notice)
                )
            }
        })

        return binding.root
    }

    fun startWithKakao() {
        val disposable = LoginClient.rx.loginWithKakaoTalk(parent)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                progressDialog.show()
                startViewModel.startWithKakao(it.accessToken)
            }, {
                dialog.show(
                    getString(R.string.text_kakao_login_failed),
                    getString(R.string.text_kakao_login_failed_notice)
                )
            })
        compositeDisposable.add(disposable)
    }

    fun startWithEmail() {
        val direction = StartFragmentDirections.actionStartFragmentToSignupFragment()
        findNavController().navigate(direction)
    }

    fun loginWithEmail() {
        val direction = StartFragmentDirections.actionStartFragmentToLoginFragment()
        findNavController().navigate(direction)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}

private const val SUCCESS = 200
private const val LOGIN_WITH_EMAIL = 409
private const val INVALID_DATA = 412
private const val ACCOUNT_CLOSED = 423
private const val FAILED_TO_GET_TOKEN = 424
private const val UNKNOWN_API_ERROR = 500
