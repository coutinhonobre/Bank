package com.github.coutinhonobre.bank

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.github.coutinhonobre.bank.presentation.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestLoginTelaInicial {

    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)


    @Test
    fun checarComponentesEmTelaTest(){
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.textInputEditUser)).check(matches(isDisplayed()))
        onView(withId(R.id.textInputEditPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.textInputEditUser)).check(matches(withHint("User")))
        onView(withId(R.id.textInputEditPassword)).check(matches(withHint("Password")))
    }

}