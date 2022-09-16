package com.demo.views.home.fragment

import ProfileListResponseModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.demo.R
import com.demo.databinding.FragmentNotesBinding
import com.demo.views.home.activity.MainActivity
import com.demo.views.home.adapter.LikesListAdapter
import com.demo.views.home.viewmodel.NotesFragmentViewModel


class NotesFragment(
    var activity: MainActivity,
    var profileListResponseModel: ProfileListResponseModel?
) : Fragment() {
    private val notesFragmentViewModel: NotesFragmentViewModel by viewModels()
    private lateinit var fragmentNotesBinding: FragmentNotesBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,


    ): View {
        fragmentNotesBinding = FragmentNotesBinding.inflate(layoutInflater)
        return fragmentNotesBinding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNotesBinding.notesFragmentViewModel = notesFragmentViewModel
        notesFragmentViewModel.setActivityInstance(activity = activity)
        notesFragmentViewModel.setData(profileListResponseModel?.invites?.profiles?.get(0))

        fragmentNotesBinding.scrollView.fullScroll(View.FOCUS_DOWN);
        fragmentNotesBinding.scrollView.isSmoothScrollingEnabled = true;

        Glide.with(this).load(profileListResponseModel?.invites?.profiles?.get(0)?.instagramImages)
            .placeholder(
                R.drawable.smaple
            )
            .into(fragmentNotesBinding.ivNotes)

        setAdapter()
    }

    private fun setAdapter() {
        fragmentNotesBinding.rvLikes.layoutManager = GridLayoutManager(activity, 2)
        val adapter = LikesListAdapter(activity)
        fragmentNotesBinding.rvLikes.adapter = adapter
        profileListResponseModel?.likes?.likesProfiles?.let { adapter.setCorrectionList(it) }
    }
}