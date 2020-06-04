package com.github.coutinhonobre.bank

import com.github.coutinhonobre.bank.data.model.Account
import org.junit.Before

class AccountTest {

    private lateinit var account: Account

    @Before
    fun inicializar(){
        account = Account();
    }
}