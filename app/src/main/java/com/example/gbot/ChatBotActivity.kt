package com.example.gbot

import android.app.DatePickerDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gbot.databinding.ActivityChatMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class ChatBotActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatMainBinding
    var adapterChat: AdapterChat? = null
    var recyclerView: RecyclerView? = null
    var edt_departuredate_oneway: EditText? = null
    var text_one: Button? = null
    var btn_international_flight: Button? = null
    var btn_one_way: Button? = null
    var edt_from_oneway: EditText? = null
    var edt_to_oneway: EditText? = null

    var submit: Button? = null


    val chatItemClasses: MutableList<ChatItemClass> = ArrayList()

    //Admin Website Url
    var url = "https://rkuplacement.000webhostapp.com/"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityChatMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorbot)))
        // From the MainActivity, find the RecyclerView.
        recyclerView = findViewById(R.id.chat_item_rv)


//        edt_departuredate_oneway = findViewById(R.id.edt_departuredate_oneway)

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
                ChatItemClass.LayoutThree,
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
        recyclerView!!.startLayoutAnimation()
//        adapterChat!!.notifyDataSetChanged()
//        recyclerView!!.clearAnimation()
//        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
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
                ChatItemClass.LayoutFlight,
                "Flight"
            )
        )

        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);

    }

    fun domesticClick(view: View) {
        recyclerView!!.startLayoutAnimation()
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
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

        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
                "Hey John! we are checking with your pre-requisites based on your travel request"
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
                "Please allow us a movement."
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
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
                ChatItemClass.LayoutThree,
                "We have verified your checklist and we have all the info which required for your travel request"
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
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
//        recyclerView!!.scrollToPosition(chatItemClasses.size - 1)
////        recyclerView!!.startLayoutAnimation()
//
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

        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.startLayoutAnimation()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);


    }

    fun flightWayClick(view: View) {
        recyclerView!!.startLayoutAnimation()
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
                "Hey John! we are checking with your pre-requisites based on your travel request"
            )
        )

        adapterChat!!.notifyDataSetChanged()
//            adapterChat!!.notifyDataSetChanged()
//            recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
                "Please allow us a movement."
            )
        )
        adapterChat!!.notifyDataSetChanged()
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
                ChatItemClass.LayoutThree,
                "We have verified your checklist and we have all the info which required for your travel request"
            )
        )
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
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
        datePickerDialog.datePicker.setMinDate(7 * 24 * 60 * 60 * 1000 + System.currentTimeMillis())
        datePickerDialog.show()

    }

    fun insertButtonData(view: View) {
        text_one = findViewById(R.id.text_one)
        btn_international_flight = findViewById(R.id.btn_international_flight)
        btn_one_way = findViewById(R.id.btn_one_way)
        edt_from_oneway = findViewById(R.id.edt_from_oneway)
        edt_to_oneway = findViewById(R.id.edt_to_oneway)
        edt_departuredate_oneway = findViewById(R.id.edt_departuredate_oneway)
        submit = findViewById(R.id.btn_submit)
        submit!!.setOnClickListener {
            process()
        }


    }
    private fun process() {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(MyInsertApi::class.java)
        val call = api.adddata(
            text_one!!.text.toString(),
            btn_international_flight!!.text.toString(),
            btn_one_way!!.text.toString(),
            edt_from_oneway!!.text.toString(),
            edt_to_oneway!!.text.toString(),
            edt_departuredate_oneway!!.text.toString()


        )
        call!!.enqueue(object : Callback<ModelInsert?> {
            override fun onResponse(
                call: Call<ModelInsert?>,
                response: Response<ModelInsert?>,
            ) {
                text_one!!.setText("")
                btn_international_flight!!.setText("")
                btn_one_way!!.setText("")
                edt_from_oneway!!.setText("")
                edt_to_oneway!!.setText("")
                edt_departuredate_oneway!!.setText("")
                Toast.makeText(
                    this@ChatBotActivity,
                    "Data has been Successfully added.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<ModelInsert?>, t: Throwable) {
                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

}





