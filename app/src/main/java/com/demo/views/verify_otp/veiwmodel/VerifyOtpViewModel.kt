package com.demo.views.verify_otp.veiwmodel

import android.app.Dialog
import android.content.Intent
import android.content.Intent.getIntent
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
import com.demo.views.home.activity.MainActivity
import com.demo.views.login.activity.LoginActivity
import com.demo.views.verify_otp.activity.VerifyOtpActivity
import com.demo.views.verify_otp.model.VerifyOtpRequestModel
import com.demo.views.verify_otp.model.VerifyOtpResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class VerifyOtpViewModel : ViewModel() {

    private var activity: VerifyOtpActivity? = null
    val verifyOtpResponseModel = MutableLiveData<VerifyOtpResponseModel>()
    private var apiServiceProvider: ApiServiceProvider? = null
    var verifyOtpRequestModel: VerifyOtpRequestModel? = null
    var otp: ObservableField<String> = ObservableField()
    var phonenumber: ObservableField<String> = ObservableField()
    var dialog: Dialog? = null

    init {

    }

    //call verify otp api
    fun verifyOtp(view: View) {
        if (otp.get()?.isNotEmpty() == true &&
            otp.get()?.length == 4) {
            viewModelScope.launch {
                verifyOtpRequestModel =
                    VerifyOtpRequestModel(number = phonenumber.get(), otp = otp.get())
                dialog = CommonProgressUtil.showProgress(activity!!)
                withContext(Dispatchers.IO) {
                    if (activity?.let { NetworkUtil.getInstance(it).isOnline } == true) {

                        apiServiceProvider = RetrofitHelper.getInstance().getRetrofit()
                            ?.create(ApiServiceProvider::class.java)
                        val response = apiServiceProvider?.verifyOtp(verifyOtpRequestModel!!)
                        if (response?.body() != null) {

                            verifyOtpResponseModel.postValue(response.body())
                            withContext(Dispatchers.Main) {
                                dialog?.dismiss()
                                navigateToHomeScreen()
                            }

                        } else {
                            onError("Something went wrong")
                        }

                    } else {
                        onError("Please check you internet connection")
                    }

                }

            }
        } else {
            Toast.makeText(activity,
                "Please enter a valid otp", Toast.LENGTH_SHORT).show()
        }


    }

    fun onclickOnEditIcon(view: View) {
        var intent = Intent(activity!!, LoginActivity::class.java)
        activity!!.startActivity(intent)
        activity?.finish()
    }

    fun getData() {
        val intent = activity!!.intent
        phonenumber.set(intent.getSerializableExtra("number").toString())
    }

    private fun navigateToHomeScreen() {
        verifyOtpResponseModel.observe(activity!!) {
            if (it.token?.isNotEmpty() == true) {
                var intent = Intent(activity!!, MainActivity::class.java)
                intent.putExtra("token", it.token);
                activity!!.startActivity(intent)
                activity?.finish()
            }
        }

    }


    private suspend fun onError(message: String) {
        withContext(Dispatchers.Main) {
            dialog?.dismiss()
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }


    }


    fun setActivityInstance(activity: VerifyOtpActivity) {
        this.activity = activity
    }

}