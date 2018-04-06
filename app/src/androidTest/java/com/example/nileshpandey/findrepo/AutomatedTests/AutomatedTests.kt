package com.example.nileshpandey.findrepo.AutomatedTests
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import com.example.nileshpandey.findrepo.MainActivity
import com.example.nileshpandey.findrepo.AutomatedTests.Screens.SearchScreen


@RunWith(AndroidJUnit4::class)
class FindRepoTests : SearchScreen(){


    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun searchBlankTerm() {

        // To test that search button displays a list of Github repos with names 'Eggs'
        // when user clicks on search button without typing any text

        searchField.perform(click()).perform(clearText())
        searchButton.perform(click())
        Thread.sleep(3000)
        repoResult.isFocused
        repoResultList
    }

    @Test
    fun verifyFirstRepoLink(){

        //To Test that when clicked on the first item in the search result  it opens
        //the associated Github repo page in chrome browser

        searchField.perform(click())
        searchField.perform(click()).perform(typeText("CodeFitness"))
        searchButton.perform(click())
        Thread.sleep(3000)
        repoResult.isFocused
        //repoResultList.atPosition(0).perform(click())
        chromeBrowser.isFocused

    }

    @Test
    fun verifyScrolling(){

        //To Test that user can scroll the repolist results after searching for a term "Kotlin"

        searchField.perform(click()).perform(typeText("Kotlin"))
        searchButton.perform(click())
        Thread.sleep(3000)
        repoResult.isFocused
        repoResult.isScrollable
        repoResultList

    }
}
