package com.eps.creditoffer

import androidx.test.espresso.ViewAction

import android.view.View

import androidx.test.espresso.UiController
import androidx.test.espresso.matcher.ViewMatchers.*
import android.widget.SeekBar
import org.hamcrest.Matcher


class SetVisibilityViewAction(val visibility: Int) : ViewAction {

    override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(View::class.java)
    }


    override fun getDescription(): String {
        return "whatever"
    }

    override fun perform(uiController: UiController, view: View) {
        view.visibility = visibility
    }

}