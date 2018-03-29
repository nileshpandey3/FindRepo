package com.example.nileshpandey.findrepo
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
import org.junit.*
import org.junit.Rule
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.util.Log
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything


@RunWith(AndroidJUnit4::class)
class FindRepoTests {

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    lateinit var uiDevice: UiDevice


    @Test
    fun searchFunctionality() {

        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        // To test that search button displays a list of repos with names 'Eggs'
        // when user clicks on search button without typing any text
        onView(withId(R.id.SearchEditText)).perform(click()).perform(clearText())
        onView(withId(R.id.SearchButton)).perform(click())
        Thread.sleep(2000)
        val repoName = uiDevice.findObject(UiSelector().className("android.view.ViewGroup").index(0))
                .getChild(UiSelector().resourceId("com.example.nileshpandey.findrepo:id/textView")).text


        onData(anything()).inAdapterView(allOf(withId(R.id.repoListView))).atPosition(0).perform(click())
        val chromeText = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar")).text
        assertTrue(chromeText.contains(repoName.toString()))



    }



}
