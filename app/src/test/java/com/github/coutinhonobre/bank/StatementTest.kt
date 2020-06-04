package com.github.coutinhonobre.bank

import com.github.coutinhonobre.bank.data.model.Statement
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StatementTest {

    private lateinit var statement: Statement

    @Before
    fun inicializar(){
        statement = Statement("Pagamento", "Conta de luz", "2018-08-15", -50.0)
    }

    @Test
    fun comparanadoStatementIguaisTest(){
        var statementTest = Statement("Pagamento", "Conta de luz", "2018-08-15", -50.0)
        Assert.assertThat(statement, CoreMatchers.`is`(statementTest))
    }

    @Test
    fun comparandoStatementDiferenteTest(){
        var statementTest = Statement("TED Recebida", "Joao Alfredo", "2018-07-25", 745.03)
        Assert.assertThat(statement, CoreMatchers.`not`(statementTest))
    }

}