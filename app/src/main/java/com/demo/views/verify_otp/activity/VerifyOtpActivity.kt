package com.demo.views.verify_otp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.demo.R
import com.demo.databinding.ActivityVerifyOtpBinding
import com.demo.views.verify_otp.veiwmodel.VerifyOtpViewModel

class VerifyOtpActivity : AppCompatActivity() {

    private val verifyOtpViewModel: VerifyOtpViewModel by viewModels()
    private lateinit var verifyOtpBinding: ActivityVerifyOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    /**
     * used to init binding and set view model
     */
    private fun initView() {
        verifyOtpBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_verify_otp

        )
        verifyOtpBinding.verifyOtpViewModel = verifyOtpViewModel
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        verifyOtpViewModel.setActivityInstance(this)
        verifyOtpViewModel.getData()


    }
}