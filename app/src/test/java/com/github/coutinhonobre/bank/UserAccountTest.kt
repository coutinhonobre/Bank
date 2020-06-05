package com.github.coutinhonobre.bank

import com.github.coutinhonobre.bank.data.model.UserAccount
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.hamcrest.CoreMatchers.*


class UserAccountTest {

    private lateinit var userAccount: UserAccount

    @Before
    fun inicializar(){
        userAccount = UserAccount(1, "Jose da Silva Teste", "2050", "012314564", 3.3445)
    }

    @Test
    fun adicionarUmaNovaContaTest(){
        var accountTest = UserAccount(1, "Jose da Silva Teste", "2050", "012314564", 3.3445)
        Assert.assertThat(userAccount, `is`(accountTest))
    }

    @Test
    fun adicionarUmaNovaContaDiferenteTest(){
        var accountTest = UserAccount(2, "Igor Coutinho Ferreira Nobre", "3145", "09908809", 1.2345)
        Assert.assertThat(userAccount, `not`(accountTest))
    }


}