package com.github.coutinhonobre.bank

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.github.coutinhonobre.bank.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.lista_extrato.*
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
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("User ou Senha vazios!")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioEmailIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText("test.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Usuario Invalido")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioCpfIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText("1234"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Usuario Invalido")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioSenhaIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Senha Invalida")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioSenhaComCPFIncorretoTest(){
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText("03496196107"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText("12345678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Senha Invalida")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioSenhaIncorretoComLetraTest(){
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText("1234A5678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Senha Invalida")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioSenhaIncorretoComSimboloTest(){
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText("1234&5678"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withText("Senha Invalida")).check(matches(isDisplayed()))
    }

    @Test
    fun usuarioSenhaCorretosTest(){
        onView(withId(R.id.textInputEditUser)).perform(clearText(), typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.textInputEditPassword)).perform(clearText(), typeText("1234&567A8"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
        Thread.sleep(5000)
        onView(withId(R.id.recyclerViewCabecalhoListaRecentes)).check(matches(isDisplayed()))

    }




}