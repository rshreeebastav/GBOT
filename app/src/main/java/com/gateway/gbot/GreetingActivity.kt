package com.gateway.gbot

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.gateway.gbot.R
import java.util.*

class GreetingActivity : AppCompatActivity() {
    var text_greet: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)
        text_greet = findViewById<View>(R.id.text_greet) as TextView

        //For Header color
//        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorbot)))
        greetingTime() //calling the function of greeting
        //Intent to the ChatBotActivity
        val btn_travelDesk: Button = findViewById(R.id.btn_travelDesk)
        btn_travelDesk.setOnClickListener {
            val td = Intent(this@GreetingActivity, ChatBotActivity::class.java)
            //Declare for the Activity Animation
//            val b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(td)
        }

    }

    //Function for the greeting time
    fun greetingTime() {
        val cal = Calendar.getInstance()
        val jam = cal[Calendar.HOUR_OF_DAY]
        if (jam >= 0 && jam < 12) {
            text_greet!!.text = "Good Morning" + " " + "John"
        } else if (jam >= 12 && jam < 16) {
            text_greet!!.text = "Good Afternoon" + " " + "John"
        } else {
            text_greet!!.text = "Good Evening" + " " + "John"
        }
    }

    fun applyLeaveBtn(view: View) {
        noAvailableToast()

    }

    private fun noAvailableToast() {
        Toast.makeText(this@GreetingActivity,"Not Available",Toast.LENGTH_SHORT).show()
    }

    fun requestHardwareLeaveBtn(view: View) {  noAvailableToast()}
    fun registerQueryBtn(view: View) {  noAvailableToast()}
    fun myQueriesBtn(view: View) {  noAvailableToast()}
    fun outOfOfficeBtn(view: View) {  noAvailableToast()}
    fun holidayListBtn(view: View) {  noAvailableToast()}
    fun applyWfmBtn(view: View) {  noAvailableToast()}

}