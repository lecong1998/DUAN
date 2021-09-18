package com.example.movieapp.presenter

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.R
import com.example.movieapp.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        val idUser: Int = sharedPreferences.getInt("ID",-1)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_movie ->{
                    viewPager.currentItem=0
                }
                R.id.ic_search ->{
                    viewPager.currentItem=1
                }
                R.id.ic_favorite ->{
                    viewPager.currentItem=2
                }
                R.id.ic_profile ->{
                    viewPager.currentItem=3
                }
            }
            true
        }

        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        bottom_navigation.menu.findItem(R.id.ic_movie).setChecked(true)
                    }
                    1 -> {
                        bottom_navigation.menu.findItem(R.id.ic_search).setChecked(true)
                    }
                    2 -> {
                        bottom_navigation.menu.findItem(R.id.ic_favorite).setChecked(true)
                    }
                    3 -> {
                        bottom_navigation.menu.findItem(R.id.ic_profile).setChecked(true)
                    }
                }
            }
        })
    }
}