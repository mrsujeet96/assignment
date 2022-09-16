package com.demo.views.home.viewmodel

import ProfileListResponseModel
import android.app.Dialog
import android.util.Log
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

import kotlinx.coroutines.*


class MainViewModel : ViewModel() {

    private var activity: MainActivity? = null
    val profileListLiveData = MutableLiveData<ProfileListResponseModel>()
    private var apiServiceProvider: ApiServiceProvider? = null
    var token: ObservableField<String> = ObservableField()
    var dialog: Dialog? = null

    init {

    }


    //Fetch user data from api and local database
    fun getProgileList() {

        viewModelScope.launch {
            //fetch data from local data base
            dialog = CommonProgressUtil.showProgress(activity!!)
            withContext(Dispatchers.IO) {
                //fetch data from server
                if (activity?.let { NetworkUtil.getInstance(it).isOnline } == true) {
                    apiServiceProvider = RetrofitHelper.getInstance().getRetrofit()?.create(ApiServiceProvider::class.java)
                    val response = apiServiceProvider?.getProfileLidData(token.get().toString())
                    if (response?.isSuccessful == true) {
                        profileListLiveData.postValue(response.body())
                        Log.e("data", response.body().toString())
                        withContext(Dispatchers.Main) {
                            dialog?.dismiss()
                        }
                    } else {
                        onError("Error : ${response?.message()} ")
                    }

                } else {
                    Toast.makeText(NetworkUtil.context, "Please check you internet connection", Toast.LENGTH_SHORT).show()
                }


            }

        }


    }

    fun getToken() {
        val intent = activity!!.intent
        token.set(intent.getSerializableExtra("token").toString())
    }

    override fun onCleared() {
        super.onCleared()

    }


    private suspend fun onError(message: String) {
        withContext(Dispatchers.Main) {
            dialog?.dismiss()
            Toast.makeText(NetworkUtil.context, message, Toast.LENGTH_SHORT).show()
        }


    }


    fun setActivityInstance(activity: MainActivity) {
        this.activity = activity
    }


}