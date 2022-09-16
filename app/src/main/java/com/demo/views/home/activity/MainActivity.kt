package com.demo.views.home.activity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.demo.R
import com.demo.databinding.ActivityMainBinding
import com.demo.views.home.fragment.DiscoverFragment
import com.demo.views.home.fragment.MatchesFragment
import com.demo.views.home.fragment.NotesFragment
import com.demo.views.home.fragment.ProfileFragment
import com.demo.views.home.viewmodel.MainViewModel



class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels();
    private lateinit var activityBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    /**
     * used to init binding and set view model
     */
    private fun initView() {
        activityBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main

        )

        activityBinding.mainViewModel = mainViewModel
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        mainViewModel.setActivityInstance(this)
        mainViewModel.getToken();
        mainViewModel.getProgileList()
        mainViewModel.profileListLiveData.observe(this){
            if(it!=null){
                setAdapter()

            }

        }

    }

    private fun setAdapter() {
        val navigation = activityBinding.bottomNavigationView
        val discoverFragment = DiscoverFragment()
        val notesFragment = NotesFragment(this,mainViewModel.profileListLiveData.value)
        val matchesFragment = MatchesFragment()
        val profileFragment = ProfileFragment()

        navigation.setOnNavigationItemSelectedListener() {
            when (it.itemId) {
                R.id.discover -> setCurrentFragment(discoverFragment)
                R.id.notes -> setCurrentFragment(notesFragment)
                R.id.matches -> setCurrentFragment(matchesFragment)
                R.id.profile -> setCurrentFragment(profileFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

}

