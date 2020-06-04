package com.github.coutinhonobre.bank

import com.github.coutinhonobre.bank.data.model.Account
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.hamcrest.CoreMatchers.*


class AccountTest {

    private lateinit var account: Account

    @Before
    fun inicializar(){
        account = Account(1, "Jose da Silva Teste", "2050", "012314564", 3.3445)
    }

    @Test
    fun adicionarUmaNovaContaTest(){
        var accountTest = Account(1, "Jose da Silva Teste", "2050", "012314564", 3.3445)
        Assert.assertThat(account, `is`(accountTest))
    }

    @Test
    fun adicionarUmaNovaContaDiferenteTest(){
        var accountTest = Account(2, "Igor Coutinho Ferreira Nobre", "3145", "09908809", 1.2345)
        Assert.assertThat(account, `not`(accountTest))
    }


}