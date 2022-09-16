package com.demo.views.login.veiwmodel

import android.app.Dialog
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.repository.ApiServiceProvider
import com.demo.repository.RetrofitHelper
import com.demo.utils.CommonProgressUtil
import com.demo.utils.NetworkUtil
import com.demo.views.login.activity.LoginActivity
import com.demo.views.login.model.LoginRequestModel
import com.demo.views.login.model.LoginResponseModel
import com.demo.views.verify_otp.activity.VerifyOtpActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginViewModel : ViewModel() {

    private var activity: LoginActivity? = null
    val loginResponse = MutableLiveData<LoginResponseModel>()
    private var apiServiceProvider: ApiServiceProvider? = null
    var loginRequestModel: LoginRequestModel? = null
    var phoneNumber: ObservableField<String> = ObservableField("9876543212")
    var countryCode: ObservableField<String> = ObservableField("+91")
    var dialog: Dialog?=null

//   call get otp api
    fun getOtp(view: View) {
        if (phoneNumber.get()?.isNotEmpty() == true &&
            phoneNumber.get()?.length == 10) {
            viewModelScope.launch {
                loginRequestModel = LoginRequestModel(number = countryCode.get() + phoneNumber.get())
                dialog = CommonProgressUtil.showProgress(activity!!)
                withContext(Dispatchers.IO) {
                    if (activity?.let { NetworkUtil.getInstance(it).isOnline } == true) {

                        apiServiceProvider = RetrofitHelper.getInstance().getRetrofit()?.create(ApiServiceProvider::class.java)
                        val response = apiServiceProvider?.getOpt(loginRequestModel!!)
                        if (response?.body() != null) {

                            loginResponse.postValue(response.body())
                            withContext(Dispatchers.Main) {
                                dialog?.dismiss()
                                navigateToVerifyOtpScreen()
                            }

                        } else {

                            onError("Something went wrong")
                        }

                    } else {
                        onError("Please check you internet connection")
                    }

                }

            }
        }else{
            Toast.makeText(activity,
                "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
        }

    }

    private fun navigateToVerifyOtpScreen() {
        loginResponse.observe(activity!!) {
            if (it.status) {
                var intent = Intent(activity!!, VerifyOtpActivity::class.java)
                intent.putExtra("number", loginRequestModel!!.number);
                activity!!.startActivity(intent)
            }
        }

    }

    private suspend fun onError(message: String) {
        withContext(Dispatchers.Main) {
            dialog?.dismiss()
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }


    }

    fun setActivityInstance(activity: LoginActivity) {
        this.activity = activity
    }


}