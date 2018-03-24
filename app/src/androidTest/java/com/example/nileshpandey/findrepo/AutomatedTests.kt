package com.example.nileshpandey.findrepo
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions.clearText
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import android.support.test.rule.ActivityTestRule
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import org.junit.*
import org.junit.Rule
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
class FindRepoTests {

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun searchFunctionality() {
        // To test that search button works
        onView(withId(R.id.SearchEditText)).perform(click()).perform(clearText())
        onView(withId(R.id.SearchButton)).perform(click())



    }
}
