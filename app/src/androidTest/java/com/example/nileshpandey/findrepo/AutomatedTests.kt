package com.example.nileshpandey.findrepo
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;
import org.hamcrest.CoreMatchers.*
import java.util.regex.Pattern.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.nileshpandey.findrepo.Screens.ResultScreen
import com.example.nileshpandey.findrepo.Screens.SearchScreen


@RunWith(AndroidJUnit4::class)
class FindRepoTests : ResultScreen(){

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    override lateinit var uiDevice: UiDevice

    @Test
    fun searchBlankTerm() {

        // To test that search button displays a list of Github repos with names 'Eggs'
        // when user clicks on search button without typing any text

        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        searchField
        clickSearchButton
        Thread.sleep(3000)
        repoResultList
    }

    @Test
    fun verifyFirstRepoLink(){

        //To Test that when clicked on the first item in the search result repoList it opens
        //the associated Github repo page in chrome browser

        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        searchField.perform(click())
        clickSearchButton
        Thread.sleep(3000)
        repoResultList.atPosition(0).perform(click())
        assertTrue(chromeText.contains(firstRepoNameText.toString()))

    }


}
