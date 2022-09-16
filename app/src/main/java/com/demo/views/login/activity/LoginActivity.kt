package com.demo.views.login.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.demo.R
import com.demo.databinding.ActivityLoginBinding
import com.demo.views.login.veiwmodel.LoginViewModel
import com.demo.views.verify_otp.activity.VerifyOtpActivity

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var loginActivityBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginActivityBinding.loginViewModel = loginViewModel
        loginViewModel.setActivityInstance(this)

    }
}