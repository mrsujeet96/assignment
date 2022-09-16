package com.demo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import java.lang.Exception

class NetworkUtil {
    var connectivityManager: ConnectivityManager? = null
    var connected = false

    companion object {
        private val instance = NetworkUtil()
        var context: Context? = null
        fun getInstance(ctx: Context): NetworkUtil {
            context = ctx.applicationContext
            return instance
        }
    }


    val isOnline: Boolean
        get() {
            try {
                connectivityManager = context
                    ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager!!.activeNetworkInfo
                connected = networkInfo != null && networkInfo.isAvailable &&
                        networkInfo.isConnected
                return connected
            } catch (e: Exception) {

                Log.v("connectivity", e.toString())
            }
            return connected
        }


}