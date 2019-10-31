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
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Before


@RunWith(AndroidJUnit4::class)
@LargeTest
class StartActivityAndroidTest {

    private lateinit var name: String

    @get:Rule
    var startActivity: ActivityTestRule<StartActivity> =
        ActivityTestRule(StartActivity::class.java)

    @Before
    fun setUp() {
        name = "Test"
    }

    @Test
    fun makeRequisition() {
        onView(withId(R.id.editText_startName))
            .perform(typeText(name), closeSoftKeyboard())

        onView(withId(R.id.button_start))
            .perform(click())

        onView(withId(R.layout.activity_main)).check(matches(isDisplayed()))

    }

}