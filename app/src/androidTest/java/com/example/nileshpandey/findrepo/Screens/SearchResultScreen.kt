package com.example.nileshpandey.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.nileshpandey.findrepo.MainActivity
import com.example.nileshpandey.findrepo.R
import org.hamcrest.CoreMatchers
import org.junit.Rule

open class ResultScreen: SearchScreen() {

    override lateinit var uiDevice: UiDevice

    val repoResultList = Espresso.onData(CoreMatchers.anything())
            .inAdapterView(CoreMatchers.allOf(ViewMatchers.withId(R.id.repoListView)))!!

    val firstRepoNameText = uiDevice.findObject(UiSelector().className("android.view.ViewGroup").index(0))
            .getChild(UiSelector().resourceId("com.example.nileshpandey.findrepo:id/textView")).text!!

    val chromeText = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar")).text!!

}

