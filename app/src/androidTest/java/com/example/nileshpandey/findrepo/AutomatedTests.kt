package com.example.nileshpandey.findrepo
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.*
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
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.*
import java.util.logging.Handler


@RunWith(AndroidJUnit4::class)
class FindRepoTests {

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun searchFunctionality() {
        // To test that search button displays a list of repos with names 'Eggs'
        // when user clicks on search button without typing any text
        onView(withId(R.id.SearchEditText)).perform(click()).perform(clearText())
        onView(withId(R.id.SearchButton)).perform(click())
        Thread.sleep(2000)
        onData(anything()).inAdapterView(allOf(withId(R.id.repoListView))).atPosition(0).perform(click())
        onView(allOf(withId(com.android.chrome.R.id.bottom_container), isDisplayed()))

    }



}
