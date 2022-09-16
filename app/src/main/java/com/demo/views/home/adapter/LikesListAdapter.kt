package com.demo.views.home.adapter
import LikesProfiles
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.R
import com.demo.databinding.LikesListBinding
import com.demo.views.home.activity.MainActivity

import com.demo.views.home.viewmodel.LikesListViewModel

class LikesListAdapter(var activity: MainActivity) : RecyclerView.Adapter<LikesListAdapter.UserListViewHolder>() {

    var likesProfileList:ArrayList<LikesProfiles>?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val listBinding: LikesListBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.likes_list,
                parent,
                false
            )
        return UserListViewHolder(
            listBinding,
            activity,
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCorrectionList(list: ArrayList<LikesProfiles>) {
        likesProfileList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.onBind(likesProfileList!![position])
    }

    override fun getItemCount(): Int {
        return likesProfileList!!.size
    }

    class UserListViewHolder(private var binding: LikesListBinding, var activity: MainActivity) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(likesProfiles: LikesProfiles) {
            binding.likesListViewModel = LikesListViewModel(
                activity,
                likesProfiles
            )

            Glide.with(activity).load(likesProfiles.avatar)
                .placeholder(
                    R.drawable.smaple
                )
                .into(binding.ivLikes)

        }
    }
}