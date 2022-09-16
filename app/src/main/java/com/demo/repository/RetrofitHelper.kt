package com.demo.repository


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object RetrofitHelper {
        private val instance = RetrofitHelper()

        fun getInstance(): com.demo.repository.RetrofitHelper {
            return instance
        }
    }

    private var retrofit: Retrofit? = null

    private val base_url = "https://testa2.aisle.co/V1/"

    fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}