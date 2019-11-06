package com.eps.creditoffer

import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not
import org.junit.Before


@RunWith(AndroidJUnit4::class)
@LargeTest
class OverdraftConfirmationActivityAndroidTest {

    private lateinit var result: String


    @get:Rule
    var overdraftConfirmationActivity: ActivityTestRule<OverdraftConfirmation> =
        ActivityTestRule(OverdraftConfirmation::class.java)

    @Before
    fun setUp(){
        result = "Usar Cheque Especial"
    }

    @Test
    fun confirmationOverdraf(){

        onView(withId(R.id.checkBox2))
            .check(matches(isNotChecked()))
            .perform(click())
            .check(matches(isChecked()))

        onView(withId(R.id.activateOverdraft))
            .perform(click())

        onView(withId(R.id.textView2))
            .check(matches(withText(result)))
    }

}