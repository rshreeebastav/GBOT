package com.example.gbot

import android.text.Layout

class ChatItemClass {
    // This variable ViewType specifies
    // which out of the two layouts
    // is expected in the given item
    var viewType: Int

    // getter and setter methods for the text variable
    // String variable to hold the TextView
    // of the first item.
    var text: String? = null
    var textthree: String? = null
    var textfour: String? = null
    var textfive: String? = null
    var text_from_oneway: String? = null

    // public constructor for the first layout
    constructor(viewType: Int, text: String?) {
        this.text = text
        this.textthree = text
        this.textfour = text
        this.textfive = text
        this.text_from_oneway = text
        this.viewType = viewType
    }

    // Variables for the item of second layout

    var text_one: String? = null
    var text_two: String? = null

    // public constructor for the second layout
    constructor(
        viewType: Int, icon: Int, text_one: String?,
        text_two: String?
    ) {

        this.text_one = text_one
        this.text_two = text_two
        this.viewType = viewType
    }


    companion object {
        // Integers assigned to each layout
        // these are declared static so that they can
        // be accessed from the class name itself
        // And final so that they are not modified later
//        const val LayoutOne = 0
        const val LayoutTwo = 1
        const val LayoutThree = 2
        const val LayoutFour = 3
        const val LayoutFive = 4
        const val LayoutSix = 5
    }
}