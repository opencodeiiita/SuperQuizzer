package com.example.superquizzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        Handler((Looper.getMainLooper())).postDelayed({
            val intent = Intent(this@SplashActivity,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}