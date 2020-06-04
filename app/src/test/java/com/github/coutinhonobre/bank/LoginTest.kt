package com.github.coutinhonobre.bank

import com.github.coutinhonobre.bank.data.model.User
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginTest {

    private lateinit var user: User

    @Before
    fun inicializar(){
        user = User();
    }

    @Test
    fun adicionarUsuarioCpfSimplesNaoNuloTest(){
        user.user = "66868605064"
        user.password = "A1*teste"
        assertEquals(true, user.isValido())
    }

    @Test
    fun adicionarUsuarioEmailSimplesNaoNuloTest(){
        user.user = "email@teste.com"
        user.password = "A1*teste"
        assertEquals(true, user.isValido())
    }

    @Test
    fun adicionarUsuarioCpfSimplesNaoValidoTest(){
        user.user = "66868605064978798"
        user.password = "A1*teste"
        assertEquals(false, user.isValido())
    }

    @Test
    fun adicionarUsuarioEmailSimplesNaoValidoTest(){
        user.user = "email.teste.com"
        user.password = "A1*teste"
        assertEquals(false, user.isValido())
    }

    @Test
    fun adicionarUsuarioSenhaNaoValidoTest(){
        user.user = "email.teste.com"
        user.password = "A11teste"
        assertEquals(false, user.isValido())
    }




}