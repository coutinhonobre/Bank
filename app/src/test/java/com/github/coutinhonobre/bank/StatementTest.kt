package com.github.coutinhonobre.bank

import com.github.coutinhonobre.bank.data.model.Statement
import org.junit.Before

class StatementTest {

    private lateinit var statement: Statement

    @Before
    fun inicializar(){
        statement = Statement("Pagamento", "Conta de luz", "2018-08-15", -50)
    }

}