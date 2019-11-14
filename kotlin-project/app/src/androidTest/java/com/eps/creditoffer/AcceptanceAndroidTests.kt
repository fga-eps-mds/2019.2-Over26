package com.eps.creditoffer

import android.view.View
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
import com.eps.creditoffer.activities.StartActivity
import org.junit.Before


@RunWith(AndroidJUnit4::class)
@LargeTest
class AcceptanceAndroidTests {

    private lateinit var name: String

    @get:Rule
    var startActivity: ActivityTestRule<StartActivity> =
        ActivityTestRule(StartActivity::class.java)

    @Before
    fun setUp() {
        name = "Test"
    }

    @Test
    fun startAplication() {
        onView(withId(R.id.editText_startName))
            .perform(typeText(name), closeSoftKeyboard())

        onView(withId(R.id.button_start))
            .perform(click())

        this.checkIfMainActivityIsVisible()

        this.checkEligibility()
        this.confirmationOverdraf()
        this.trackLimit()
    }

    private fun checkEligibility() {
        onView(withId(R.id.imageView5))
            .perform(click())

        onView(withId(R.id.eligibility_button))
            .perform(click())

        onView(withId(R.id.textView))
            .check(matches(withText("Ativação de Cheque Especial")))
    }

    private fun confirmationOverdraf() {
        onView(withId(R.id.checkBox2))
            .check(matches(isNotChecked()))
            .perform(click())
            .check(matches(isChecked()))

        onView(withId(R.id.activateOverdraft))
            .perform(click())

        this.checkIfMainActivityIsVisible()
    }

    private fun trackLimit() {
        onView(withId(R.id.imageView2))
            .perform(click())

        onView(withId(R.id.seek_bar))
            .perform(SetProgressViewAction(100))

        onView(withId(R.id.seek_bar))
            .perform(SetProgressViewAction(10))

        onView(withId(R.id.textView_cur))
            .perform(click())
            .check(matches(withText("R$10")))

        onView(withId(R.id.save))
            .perform(SetVisibilityViewAction(View.VISIBLE))
            .perform(click())

        this.checkIfMainActivityIsVisible()
    }

    private fun checkIfMainActivityIsVisible() {
        onView(withId(R.id.textView))
            .check(matches(withText("Crédito e Cheque Especial")))
    }

}