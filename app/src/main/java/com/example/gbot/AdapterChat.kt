package com.example.gbot

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.LinearLayout
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class AdapterChat     // public constructor for this class
    (private val chatItemClassList: List<ChatItemClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // Override the getItemViewType method.
    // This method uses a switch statement
    // to assign the layout to each item
    // depending on the viewType passed
    override fun getItemViewType(position: Int): Int {
        return when (chatItemClassList[position].viewType) {
//            0 -> ChatItemClass.LayoutOne
            1 -> ChatItemClass.LayoutTwo
            2 -> ChatItemClass.LayoutThree
            3 -> ChatItemClass.LayoutFour
            4 -> ChatItemClass.LayoutFive
            5 -> ChatItemClass.LayoutSix
            else -> -1
        }
    }

    // Create classes for each layout ViewHolder.
//    internal inner class LayoutOneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val textview: TextView
//        val linearLayout: LinearLayout
//
//        init {
//
//            // Find the Views
//            textview = itemView.findViewById(R.id.text)
//            linearLayout = itemView.findViewById(R.id.itemCbGrettingLlMain)
//
//        }
//
//        // method to set the views that will
//        // be used further in onBindViewHolder method.
//        fun setView(text: String?) {
//            textview.text = text
//        }
//    }

    // similarly a class for the second layout is also
    // created.
    internal inner class LayoutTwoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val text_one: TextView
        private val text_two: TextView
        val linearLayout: LinearLayout


        init {

            text_one = itemView.findViewById(R.id.text_one)
            text_two = itemView.findViewById(R.id.text_two)
            linearLayout = itemView.findViewById(R.id.itemCbBookingTypeLl)
        }

        fun setViews(
            textOne: String?,
            textTwo: String?,
        ) {

            text_one.text = textOne
            text_two.text = textTwo
        }
    }

    internal inner class LayoutThreeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textview: TextView
        val linearLayout: LinearLayout

        init {

            // Find the Views
            textview = itemView.findViewById(R.id.textthree)
            linearLayout = itemView.findViewById(R.id.itemCbMessageLlMain)
        }

        // method to set the views that will
        // be used further in onBindViewHolder method.
        fun setViewe(textthree: String?) {
            textview.text = textthree
        }
    }


    internal inner class LayoutFourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textview: TextView
        val linearLayout: LinearLayout

        init {

            // Find the Views
            textview = itemView.findViewById(R.id.textfour)
            linearLayout = itemView.findViewById(R.id.itemCbPrerequisiteslistLl)
        }

        // method to set the views that will
        // be used further in onBindViewHolder method.
        fun setViewFour(textfour: String?) {
            textview.text = textfour
        }
    }


    internal inner class LayoutFiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textview: TextView
        val linearLayout: LinearLayout

        init {

            // Find the Views
            textview = itemView.findViewById(R.id.btn_one_way)
            linearLayout = itemView.findViewById(R.id.itemCbTripTypeLl)
        }

        // method to set the views that will
        // be used further in onBindViewHolder method.
        fun setViewFive(textfive: String?) {
            textview.text = textfive
        }
    }
    internal inner class LayoutSixViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textview: TextView
        val constraintLayout: ConstraintLayout

        init {

            // Find the Views
            textview = itemView.findViewById(R.id.text_from_oneway)
            constraintLayout = itemView.findViewById(R.id.itemCbTripOptionOneWayCl)
        }

        // method to set the views that will
        // be used further in onBindViewHolder method.
        fun setViewSix(text_from_oneway: String?) {
            textview.text = text_from_oneway
        }
    }


    // In the onCreateViewHolder, inflate the
    // xml layout as per the viewType.
    // This method returns either of the
    // ViewHolder classes defined above,
    // depending upon the layout passed as a parameter.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
//            ChatItemClass.LayoutOne -> {
//                val layoutOne =
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.item_greeting_chatbot, parent, false)
//                LayoutOneViewHolder(layoutOne)
//
//            }
            ChatItemClass.LayoutTwo -> {
                val layoutTwo =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_booking_type_chatbot, parent, false)
                LayoutTwoViewHolder(layoutTwo)
            }
            ChatItemClass.LayoutThree -> {
                val layoutThree =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_chatbot_message, parent, false)
                LayoutThreeViewHolder(layoutThree)
            }

            ChatItemClass.LayoutFour -> {
                val layoutFour =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_prerequisites_list_chatbot, parent, false)
                LayoutFourViewHolder(layoutFour)
            }
            ChatItemClass.LayoutFive -> {
                val layoutFive =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_trip_option_chatbot, parent, false)
                LayoutFiveViewHolder(layoutFive)
            }
            ChatItemClass.LayoutSix -> {
                val layoutSix =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_trip_option_one_way_chatbot, parent, false)
                LayoutSixViewHolder(layoutSix)
            }
//
            else -> {

                val layoutTwo =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_booking_type_chatbot, parent, false)
                LayoutTwoViewHolder(layoutTwo)
            }

        }
    }

    // In onBindViewHolder, set the Views for each element
    // of the layout using the methods defined in the
    // respective ViewHolder classes.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (chatItemClassList[position].viewType) {
//            ChatItemClass.LayoutOne -> {
//                val text = chatItemClassList[position].text
//                (holder as LayoutOneViewHolder).setView(text)
//
//                // The following code pops a toast message
//                // when the item layout is clicked.
//                // This message indicates the corresponding
//                // layout.
//                holder.linearLayout.setOnClickListener { view ->
//                    Toast.makeText(view.context, "Hello from Layout One!", Toast.LENGTH_SHORT)
//                        .show()
//
//
//                }
//            }
            ChatItemClass.LayoutTwo -> {
                val text_one = chatItemClassList[position].text_one
                val text_two = chatItemClassList[position].text_two
                (holder as LayoutTwoViewHolder).setViews(text_one, text_two)
                holder.linearLayout.setOnClickListener { view ->
                    Toast.makeText(view.context, "Hello from Layout Two!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            ChatItemClass.LayoutThree -> {
                val text = chatItemClassList[position].textthree
                (holder as LayoutThreeViewHolder).setViewe(text)

                // The following code pops a toast message
                // when the item layout is clicked.
                // This message indicates the corresponding
                // layout.
                holder.linearLayout.setOnClickListener { view ->
                    Toast.makeText(view.context, "Hello from Layout One!", Toast.LENGTH_SHORT)
                        .show()


                }
            }
            ChatItemClass.LayoutFour -> {
                val text = chatItemClassList[position].textfour
                (holder as LayoutFourViewHolder).setViewFour(text)

                // The following code pops a toast message
                // when the item layout is clicked.
                // This message indicates the corresponding
                // layout.
                holder.linearLayout.setOnClickListener { view ->
                    Toast.makeText(view.context, "Hello from Layout Four!", Toast.LENGTH_SHORT)
                        .show()


                }
            }
            ChatItemClass.LayoutFive -> {
                val text = chatItemClassList[position].textfive
                (holder as LayoutFiveViewHolder).setViewFive(text)

                // The following code pops a toast message
                // when the item layout is clicked.
                // This message indicates the corresponding
                // layout.
                holder.linearLayout.setOnClickListener { view ->
                    Toast.makeText(view.context, "Hello from Layout Five!", Toast.LENGTH_SHORT)
                        .show()


                }
            }
                ChatItemClass.LayoutSix -> {
                    val text_from_oneway = chatItemClassList[position].text_from_oneway
                    (holder as LayoutSixViewHolder).setViewSix(text_from_oneway)

                    // The following code pops a toast message
                    // when the item layout is clicked.
                    // This message indicates the corresponding
                    // layout.
                    holder.constraintLayout.setOnClickListener { view ->
                        Toast.makeText(view.context, "Hello from Layout Six!", Toast.LENGTH_SHORT)
                            .show()



                }
            }
            else -> return
        }
    }

    // This method returns the count of items present in the
    // RecyclerView at any given time.
    override fun getItemCount(): Int {
        return chatItemClassList.size
    }

}