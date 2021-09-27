package gst.trainingcourse.movie_home.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import gst.trainingcourse.movie_home.R
import gst.trainingcourse.movie_home.film.adapter_pageView
import kotlinx.android.synthetic.main.activity_appmovie.*
import kotlinx.android.synthetic.main.activity_main.*

class Appmovie : AppCompatActivity() {

    var adapter : adapter_pageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appmovie)

        setSupportActionBar(home_toolbar)
        val home_appbar = supportActionBar

        adapter = adapter_pageView(supportFragmentManager)
        adapter!!.addFragment(FragmentHome(),"Home")
        adapter!!.addFragment(FragmentFilm(),"Film")
        adapter!!.addFragment(FragmentTV(),"TV")
        adapter!!.addFragment(FragmentProfile(),"Profile")
        viewpager_activity?.adapter = adapter

        buttom_navigation?.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home ->{
                    viewpager_activity.currentItem=0
                    home_toolbar.title = "HOME"
                }
                R.id.film ->{
                    viewpager_activity.currentItem=1
                    home_toolbar.title = "FILM"
                }
                R.id.tv ->{
                    viewpager_activity.currentItem=2
                    home_toolbar.title = "TV"
                }
                R.id.profile ->{
                    viewpager_activity.currentItem=3
                    home_toolbar.title = "PROFILE"
                }
            }
            true
        }

        viewpager_activity.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
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
                        buttom_navigation.menu.findItem(R.id.home).setChecked(true)
                    }
                    1 -> {
                        buttom_navigation.menu.findItem(R.id.film).setChecked(true)
                    }
                    2 -> {
                        buttom_navigation.menu.findItem(R.id.tv).setChecked(true)
                    }
                    3 -> {
                        buttom_navigation.menu.findItem(R.id.profile).setChecked(true)
                    }
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.menu_search -> {
                fragmentsearch()
            }
            R.id.menu_notifications -> {
                fragmentnotifications()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun fragmentsearch()
    {
        supportFragmentManager.beginTransaction()
            .add(R.id.framelayout_movie,FragmentSearch(),FragmentSearch::class.java.name)
            .addToBackStack(FragmentSearch::class.java.name)
            .commit()
    }
    fun fragmentnotifications()
    {
        supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout_movie,FragmentNotification(),FragmentNotification::class.java.name)
            .addToBackStack(FragmentNotification::class.java.name)
            .commit()
    }

}