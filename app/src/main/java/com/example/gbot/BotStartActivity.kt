package com.example.gbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.ColorDrawable

import com.google.android.material.floatingactionbutton.FloatingActionButton

class BotStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_start)
        //For Header color
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorbot)))
        //Intent to the mainActivity
        val floatingbutton: FloatingActionButton = findViewById(R.id.floating_btn)
        floatingbutton.setOnClickListener {
            val fb = Intent(this@BotStartActivity, GreetingActivity::class.java)
            //Declare for the Activity Animation
            val b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(fb, b)
        }
    }
}