package com.example.gbot

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class ChatBotActivity : AppCompatActivity() {
    var adapterChat: AdapterChat? = null
    var recyclerView: RecyclerView? = null

    val chatItemClasses: MutableList<ChatItemClass> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat_main)
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
                ChatItemClass.LayoutOne,
                "Good Afternoon"
            )
        )




        adapterChat = AdapterChat(chatItemClasses)

        // set the adapter
        recyclerView!!.adapter = adapterChat
        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1)

    }



    fun travelDesk(view: View) {


        recyclerView!!.startLayoutAnimation()

        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutThree,
                "Hey John! where u need to travel?"
            )
        )

        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1)
        chatItemClasses.add(
            ChatItemClass(
                ChatItemClass.LayoutTwo, R.drawable.receiver,
                "International", "Domestic"
            )
        )

        adapterChat!!.notifyDataSetChanged()
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1)
    }

        fun internationalClick(view: View) {
            recyclerView!!.startLayoutAnimation()
            adapterChat!!.notifyDataSetChanged()
            recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
            chatItemClasses.add(
                ChatItemClass(
                    ChatItemClass.LayoutThree,
                    "Hey John! we are checking with your pre-requisites based on your travel request"
                )
            )
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
        }

    fun domesticClick(view: View) {
        recyclerView!!.startLayoutAnimation()

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
        recyclerView!!.scrollToPosition(chatItemClasses.size - 1);
    }

}



