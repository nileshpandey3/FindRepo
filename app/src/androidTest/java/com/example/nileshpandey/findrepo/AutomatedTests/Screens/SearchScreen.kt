package com.example.nileshpandey.findrepo.AutomatedTests.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.uiautomator.UiDevice
import com.example.nileshpandey.findrepo.MainActivity
import com.example.nileshpandey.findrepo.R
import org.hamcrest.CoreMatchers
import org.junit.Rule

open class SearchScreen : ResultScreen() {

    val searchField = Espresso.onView(withId(R.id.SearchEditText))!!
    val searchButton = Espresso.onView(withId(R.id.SearchButton))!!

}