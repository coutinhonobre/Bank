package com.github.coutinhonobre.bank.presentation.extrato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.coutinhonobre.bank.R
import com.github.coutinhonobre.bank.data.model.Statement
import kotlinx.android.synthetic.main.cabecalho_extrato.*
import kotlinx.android.synthetic.main.lista_extrato.*

class ExtratoActivity : AppCompatActivity() {

    private lateinit var loginViewModel: ExtratoViewModel

    private lateinit var extratoList: MutableList<Statement>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extrato)

        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ExtratoViewModel::class.java)

        loginViewModel.userAccount.observe(this, Observer {
            if (it.isNotEmpty()) {
                textViewCabecalhoExtratoNome.text = it[0].name
                textViewCabecalhoExtratoContaNumero.text = it[0].bankAccount
                textViewCabecalhoExtratoSaldo.text = it[0].balance.toString()
            }
        })

        imageViewCabecalhoExtratoLogout.setOnClickListener {
            onBackPressed()
        }

        extratoList = mutableListOf()
        for (x in 1..500){
            extratoList.add(
                Statement(
                    title = "title ${x}",
                    desc = "desc ${x}",
                    date = "date ${x}",
                    value = (x * 5).toDouble()
                )
            )
        }

        recyclerViewCabecalhoListaRecentes.layoutManager = LinearLayoutManager(this.applicationContext)
        recyclerViewCabecalhoListaRecentes.adapter = ExtratoAdapter(extratoList)



    }

    override fun onResume() {
        super.onResume()

    }
}
