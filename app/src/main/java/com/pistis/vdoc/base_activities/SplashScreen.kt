package com.pistis.vdoc.base_activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.pistis.vdoc.activities.SintomaActivity
import symptomsme.symptomsme.empsoft.projeto.symptomsme.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
//    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this@SplashScreen, SintomaActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}