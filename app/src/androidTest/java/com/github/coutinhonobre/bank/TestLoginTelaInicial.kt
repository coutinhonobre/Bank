package com.github.coutinhonobre.bank

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
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

    @Test
    fun checarUserESenhaVazioTest(){
        onView(withId(R.id.button)).perform(click())
        onView(withText("User ou Senha vazios!")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioEmailIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(typeText("test.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Usuario Invalido")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioCpfIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(typeText("1234"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Usuario Invalido")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioSenhaIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Senha Invalida")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioSenhaComCPFIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(typeText("03496196107"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Senha Invalida")).check(matches(isDisplayed()))
    }






}