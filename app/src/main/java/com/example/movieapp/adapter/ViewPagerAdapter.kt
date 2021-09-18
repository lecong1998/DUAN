package com.example.movieapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movieapp.presenter.favorite.FavoriteFragment
import com.example.movieapp.presenter.home.HomeFragment
import com.example.movieapp.presenter.profile.ProfileFragment
import com.example.movieapp.presenter.search.SearchFragment

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return SearchFragment()
            }
            2 -> {
                return FavoriteFragment()
            }
            3 -> {
                return ProfileFragment()
            }
            else -> {
                return HomeFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }
}