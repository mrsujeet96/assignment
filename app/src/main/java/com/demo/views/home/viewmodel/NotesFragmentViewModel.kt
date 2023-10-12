package com.demo.views.home.viewmodel

import Profiles
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.demo.views.home.activity.MainActivity


class NotesFragmentViewModel : ViewModel() {

    private var profiles: Profiles? = null
    var activity: MainActivity? = null
    fun setActivityInstance(activity: MainActivity) {
        this.activity = activity
    }

    fun setData(profiles: Profiles?) {
        this.profiles = profiles
    }

    fun getName(): String? {
        return profiles?.generalInformation?.firstName + ", " + profiles?.generalInformation?.age.toString()
    }




    fun getProfileImage(): String? {
        return profiles?.instagramImages
    }
}