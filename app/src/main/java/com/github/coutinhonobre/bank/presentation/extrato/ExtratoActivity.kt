package com.github.coutinhonobre.bank.presentation.extrato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.coutinhonobre.bank.R
import com.github.coutinhonobre.bank.apinetwork.login.TipoMensagem
import com.github.coutinhonobre.bank.data.model.Statement
import kotlinx.android.synthetic.main.cabecalho_extrato.*
import kotlinx.android.synthetic.main.lista_extrato.*

class ExtratoActivity : AppCompatActivity() {

    private lateinit var extratoViewModel: ExtratoViewModel

    private lateinit var extratoList: MutableList<Statement>

    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extrato)

        extratoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ExtratoViewModel::class.java)

        extratoViewModel.userAccount.observe(this, Observer {
            if (it.isNotEmpty()) {
                textViewCabecalhoExtratoNome.text = it[0].name
                textViewCabecalhoExtratoContaNumero.text = it[0].bankAccount
                textViewCabecalhoExtratoSaldo.text = it[0].balance.toString()

                extratoViewModel.buscarExtrato(it[0].userId.toString())
                userId = it[0].userId
            }
        })

        imageViewCabecalhoExtratoLogout.setOnClickListener {
            onBackPressed()
        }

        extratoViewModel.mensagem.observe(this, Observer {
            if (it.tipo == TipoMensagem.ERROR){
                viewFlipperCabecalhoListaRecentes.displayedChild = 2
                textViewCabecalhoListaRecentesError.text = it.descricao
            }
        })

        extratoViewModel.extrato.observe(this, Observer {
            it.let {
                viewFlipperCabecalhoListaRecentes.displayedChild = 1
                extratoList = it
                swipeRefreshCabecalhoListaRecentes.isRefreshing = false
                recyclerView()
            }
        })

        swipeRefreshCabecalhoListaRecentes.setOnRefreshListener {
            if (userId > 0 ){
                extratoViewModel.buscarExtrato(userId.toString())
            }else{
                swipeRefreshCabecalhoListaRecentes.isRefreshing = false
            }
        }

    }

    private fun recyclerView() {
        recyclerViewCabecalhoListaRecentes.layoutManager =
            LinearLayoutManager(this.applicationContext)
        recyclerViewCabecalhoListaRecentes.adapter = ExtratoAdapter(extratoList)
    }

    override fun onResume() {
        super.onResume()

    }
}
