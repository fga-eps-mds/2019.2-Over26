//package com.eps.creditoffer
//
//import android.os.SystemClock
//import android.view.View
//import androidx.test.filters.LargeTest
//import androidx.test.runner.AndroidJUnit4
//import androidx.test.rule.ActivityTestRule
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//import androidx.test.espresso.Espresso.*
//import androidx.test.espresso.assertion.ViewAssertions.matches
//import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName
//import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
//import androidx.test.espresso.intent.Intents.intended
//import androidx.test.espresso.intent.rule.IntentsTestRule
//import androidx.test.espresso.UiController
//import androidx.test.espresso.matcher.ViewMatchers.*
//import org.hamcrest.Matchers.not
//import org.junit.Before
//import android.widget.SeekBar
//import androidx.test.espresso.matcher.ViewMatchers
//import androidx.test.espresso.ViewAction
//import androidx.test.espresso.action.ViewActions.*
//import org.hamcrest.Matcher
//
//
//@RunWith(AndroidJUnit4::class)
//@LargeTest
//class TrackLimitActivityAndroidTest {
//
//    private lateinit var result: String
//
//
//    @get:Rule
//    var trackLimitActivityAndroidTest: ActivityTestRule<TrackLimit> =
//        ActivityTestRule(TrackLimit::class.java)
//
//    @Before
//    fun setUp(){
//        result = "Usar Cheque Especial"
//    }
//
////    private fun setProgress(progress: Int): ViewAction {
////        return object : ViewAction {
////            override fun perform(uiController: UiController, view: View) {
////                print("================================ TA CHEGANDO AQUI =============================================")
//////                (view as SeekBar).setProgress(progress, true)
////                (view as SeekBar).progress = progress
////            }
////
////            override fun getDescription(): String {
////                return "Set a progress on a SeekBar"
////            }
////
////            override fun getConstraints(): Matcher<View> {
////                return ViewMatchers.isAssignableFrom(SeekBar::class.java)
////            }
////        }
////    }
//
//    @Test
//    fun trackLimit(){
//        onView(withId(R.id.seek_bar))
//            .perform(SetProgressViewAction())
//
//        Thread.sleep(5000)
//
//        onView(withId(R.id.textView_cur))
//            .check(matches(withText("100.0")))
//
//        //onView(withId())
//    }
//
//
//}