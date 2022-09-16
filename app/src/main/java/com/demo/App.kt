package com.demo

import android.app.Application


//git stash
class App : Application() {
val st:String=""

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

    }
}