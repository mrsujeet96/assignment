package com.demo.repository

import ProfileListResponseModel
import com.demo.views.login.model.LoginRequestModel
import com.demo.views.login.model.LoginResponseModel
import com.demo.views.verify_otp.model.VerifyOtpRequestModel
import com.demo.views.verify_otp.model.VerifyOtpResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

import retrofit2.http.Header
import retrofit2.http.POST


interface ApiServiceProvider {

    @GET("users/test_profile_list")
    suspend fun getProfileLidData(@Header("Authorization") token: String): Response<ProfileListResponseModel?>?


    @POST("users/phone_number_login")
    suspend fun getOpt(@Body loginRequestModel: LoginRequestModel): Response<LoginResponseModel?>?

    @POST("users/verify_otp")
    suspend fun verifyOtp(@Body verifyOtpRequestModel: VerifyOtpRequestModel): Response<VerifyOtpResponseModel?>?

}