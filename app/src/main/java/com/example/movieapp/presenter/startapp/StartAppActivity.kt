package com.example.movieapp.presenter.startapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.movieapp.R
import com.example.movieapp.presenter.HomeActivity

class StartAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_app)
        Handler().postDelayed(Runnable {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        },2000)
    }
}