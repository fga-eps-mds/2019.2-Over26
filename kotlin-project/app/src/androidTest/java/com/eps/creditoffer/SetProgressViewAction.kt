package com.eps.creditoffer

import androidx.test.espresso.ViewAction

import android.view.View

import androidx.test.espresso.UiController
import androidx.test.espresso.matcher.ViewMatchers.*
import android.widget.SeekBar
import org.hamcrest.Matcher


class SetProgressViewAction(val progress: Int) : ViewAction {

    override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(SeekBar::class.java)
    }


    override fun getDescription(): String {
        return "Set a progress on a SeekBar"
    }

    override fun perform(uiController: UiController, view: View) {
        (view as SeekBar).setProgress(progress, true)
    }

}