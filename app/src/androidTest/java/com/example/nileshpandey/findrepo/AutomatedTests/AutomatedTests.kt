
package com.example.nileshpandey.findrepo.AutomatedTests
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.ViewActions.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.nileshpandey.findrepo.AutomatedTests.Screens.SearchScreen
import com.example.nileshpandey.findrepo.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FindRepoTests : SearchScreen() {


    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun searchBlankTerm() {

        // To test that search button displays a list of Github repos with names 'Eggs'
        // when user clicks on search button without typing any text

        searchField.perform(click()).perform(clearText())
        searchButton.perform(click())
        repoResult.waitForExists(3000)
        assert(repoResult.exists())
        assert(repoResult.isFocused)
    }

    @Test
    fun verifyFirstRepoLink() {

        //To Test that when clicked on the first item in the search result  it opens
        //the associated Github repo page in chrome browser

        searchField.perform(click())
        searchField.perform(click()).perform(typeText("CodeFitness"))
        searchButton.perform(click())
        repoResult.waitForExists(3000)
        repoResultList.atPosition(0).perform(click())
        assert(chromeBrowser.isFocused)

    }

    @Test
    fun verifyScrolling(){

        //To Test that user can scroll the repolist results after searching for a term "Kotlin"

        searchField.perform(click()).perform(typeText("Kotlin"))
        searchButton.perform(click())
        repoResult.waitForExists(3000)
        assert(repoResult.isFocused )
        assert(repoResult.isScrollable)

    }
}





