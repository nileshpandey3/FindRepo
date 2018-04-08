package com.example.nileshpandey.findrepo.AutomatedTests.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.nileshpandey.findrepo.MainActivity
import com.example.nileshpandey.findrepo.R
import org.hamcrest.CoreMatchers
import org.junit.Rule
import java.util.regex.Pattern.matches

open class ResultScreen {

    open val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    val repoResultList = Espresso.onData(CoreMatchers.anything())
            .inAdapterView(CoreMatchers.allOf(ViewMatchers.withId(R.id.repoListView)))!!

    val chromeBrowser = uiDevice.findObject(UiSelector().className("android.widget.FrameLayout").index(0))!!


    val waitForResults = uiDevice.findObject(UiSelector().className("android.widget.FrameLayout").index(0))


    val repoResult = uiDevice.findObject(UiSelector().resourceId("com.example.nileshpandey.findrepo:id/repoListView"))!!






}

