package com.demo.views.home.viewmodel

import LikesProfiles
import androidx.databinding.BaseObservable
import com.demo.views.home.activity.MainActivity


class LikesListViewModel(var activity: MainActivity, var likesProfiles: LikesProfiles,) : BaseObservable() {

    fun getName(): String {
        return likesProfiles.firstName ?: ""
    }


}