package com.gateway.gbot

import android.app.DatePickerDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gateway.gbot.adapter.AdapterChat

import com.gateway.gbot.databinding.ActivityChatMainBinding
import com.gateway.gbot.model.CreateRequestModel
import com.gateway.gbot.utility.Constant

import java.util.*
import kotlin.collections.ArrayList

class ChatBotActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatMainBinding
    var adapterChat: AdapterChat? = null
    var recyclerView: RecyclerView? = null
    var edt_departuredate_oneway: EditText? = null
    var edt_departuredate_roundtrip: EditText? = null
    var edt_arrivaldate_roundtrip: EditText? = null
    val chatItemClasses: MutableList<ChatItemClass> = ArrayList()


    var createRequestModel = CreateRequestModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityChatMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorbot)))
        // From the MainActivity, find the RecyclerView.
        recyclerView = findViewById(R.id.chat_item_rv)


        // Create and set the layout manager
        // For the RecyclerView.
//        val layoutManager = LinearLayoutManager(this)
        //From Bottom to up add the data
        val llm = LinearLayoutManager(this)
        llm.stackFromEnd = true     // items gravity sticks to bottom
        llm.reverseLayout = false   // item list sorting (new messages start from the bottom)

        recyclerView!!.layoutManager = llm


        // pass the arguments

        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Hey John! where u need to travel?"
            )
        )


        recyclerView!!.scrollToPosition(chatItemClasses.size - 1)
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutTwo, R.drawable.receiver,
                "International", "Domestic"
            )
        )



        adapterChat = AdapterChat(chatItemClasses)

        // set the adapter
        recyclerView!!.adapter = adapterChat
//        recyclerView!!.startLayoutAnimation()
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1)
        recyclerView!!.clearAnimation()


    }


    fun internationalClick(view: View) {
        createRequestModel.travelType = "international"
        recyclerView!!.startLayoutAnimation()
//        adapterChat!!.notifyDataSetChanged()
//        recyclerView!!.clearAnimation()
//        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Please select your Travelling Option."
            )
        )
        adapterChat!!.notifyItemInserted(chatItemClasses.size - 1)
//        adapterChat!!.notifyDataSetChanged(ChatItemClass,chatItemClasses)
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        adapterChat!!.notifyItemInserted(chatItemClasses.size - 1)
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFlight,
                "Flight"
            )
        )

        adapterChat!!.notifyItemInserted(chatItemClasses.size - 1)
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);

    }

    fun domesticClick(view: View) {
        createRequestModel.travelType = "domestic"
        recyclerView!!.startLayoutAnimation()
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Please select your Travelling Option."
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
//        chatItemClasses.add(
//            ChatItemClass(
//                ChatItemClass.LayoutFive,
//                "Flight"
//            )
//        )
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutDomesticFlight,
                "Flight"
            )
        )

    }

    fun oneWayClick(view: View) {
//        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.clearAnimation()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 4);
//       recyclerView!!.startLayoutAnimation()

        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutSix,
                "From"
            )
        )
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Do you need Accomodation?"
            )
        )
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutAccomodation,
                "Yes"
            )
        )





        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.startLayoutAnimation()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);


    }

    fun flightWayClickInternational(view: View) {
        flightForIntDom()

    }

    fun flightDomesticWayClick(view: View) {
        flightForIntDom()
    }

    fun busDomesticClickTravellingOption(view: View) {
        flightForIntDom()

    }

    fun trainDomesticClickTravellingOption(view: View) {
        flightForIntDom()


    }


    private fun flightForIntDom() {
        createRequestModel.travellingOption = "flight"
        recyclerView!!.startLayoutAnimation()
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Hey John! we are checking with your pre-requisites based on your travel request"
            )
        )
        adapterChat!!.notifyItemInserted(chatItemClasses.size - 1)
//        adapterChat!!.notifyDataSetChanged()
//            adapterChat!!.notifyDataSetChanged()
//            recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Please allow us a movement."
            )
        )
        adapterChat!!.notifyItemInserted(chatItemClasses.size - 1)
//        adapterChat!!.notifyDataSetChanged()
//            recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFour,
                "VISA"
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "We have verified your checklist and we have all the info which required for your travel request"
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Please select your journey type"
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFive,
                "One Way"
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        recyclerView!!.clearAnimation()
    }

    fun oneWayCalendar(view: View) {

        edt_departuredate_oneway = findViewById(R.id.edt_departuredate_oneway)

        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // on below line we are creating a
        // variable for date picker dialog.
        val datePickerDialog = DatePickerDialog(
            // on below line we are passing context.
            this, { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                edt_departuredate_oneway!!.setText(dat)
            }, year, month, day
        )
//        datePickerDialog.datePicker.minDate = System.currentTimeMillis()
//        datePickerDialog.datePicker.setMaxDate(System.currentTimeMillis() - (System.currentTimeMillis() % (24 * 60 * 60 * 1000)));
        datePickerDialog.datePicker.setMinDate(Constant.minimumBookingDateCriteria * 24 * 60 * 60 * 1000 + System.currentTimeMillis())
        datePickerDialog.show()

    }


    fun roundWayClick(view: View) {

        recyclerView!!.startLayoutAnimation()
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutRoundTrip,
                "From: "
            )
        )
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Do you need Accomodation?"
            )
        )
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutAccomodation,
                "Yes"
            )
        )

        adapterChat!!.notifyDataSetChanged()
//            adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);


    }

    fun roundTripDepartureDateCalendar(view: View) {
        edt_departuredate_roundtrip = findViewById(R.id.edt_departuredate_roundtrip)

        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // on below line we are creating a
        // variable for date picker dialog.
        val datePickerDialog = DatePickerDialog(
            // on below line we are passing context.
            this, { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                edt_departuredate_roundtrip!!.setText(dat)
            }, year, month, day
        )
//        datePickerDialog.datePicker.minDate = System.currentTimeMillis()
//        datePickerDialog.datePicker.setMaxDate(System.currentTimeMillis() - (System.currentTimeMillis() % (24 * 60 * 60 * 1000)));
        datePickerDialog.datePicker.setMinDate(Constant.minimumBookingDateCriteria * 24 * 60 * 60 * 1000 + System.currentTimeMillis())
        datePickerDialog.show()


    }

    fun roundTripArrivalDateCalendar(view: View) {

        edt_arrivaldate_roundtrip = findViewById(R.id.edt_arrivaldate_roundtrip)

        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // on below line we are creating a
        // variable for date picker dialog.
        val datePickerDialog = DatePickerDialog(
            // on below line we are passing context.
            this, { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                edt_arrivaldate_roundtrip!!.setText(dat)
            }, year, month, day
        )
        datePickerDialog.datePicker.minDate = System.currentTimeMillis()
//        datePickerDialog.datePicker.setMaxDate(System.currentTimeMillis() - (System.currentTimeMillis() % (24 * 60 * 60 * 1000)));
//        datePickerDialog.datePicker.setMinDate(7 * 24 * 60 * 60 * 1000 + System.currentTimeMillis())
        datePickerDialog.show()


    }

    fun yesAccomodationClick(view: View) {
        recyclerView!!.startLayoutAnimation()
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutFirstBotMessage,
                "Tell us your preferred area to stay or select from map"
            )
        )

        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutMap,
                "Amster"
            )
        )

        recyclerView!!.scrollToPosition(chatItemClasses.size - 1)
        println("traveltype=${createRequestModel.travelType}")

    }

    fun multiCityClick(view: View) {
        Toast.makeText(this@ChatBotActivity, "Is in Progress", Toast.LENGTH_SHORT).show()

    }

    fun createRequestTravelAccomodationNo(view: View) {
        Toast.makeText(
            this@ChatBotActivity,
            "Travel Request created Successfully",
            Toast.LENGTH_SHORT
        ).show()

    }

    fun createRequestTravelMap(view: View) {
        Toast.makeText(
            this@ChatBotActivity,
            "Travel Request created Successfully",
            Toast.LENGTH_SHORT
        ).show()

    }


}





